package com.erc.app;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.erc.app.welchallyn.entities.PatientVitalSignDTO;

import simplexml.SimpleXml;
import simplexml.model.Element;

 
// Each Client Connection will be managed in a dedicated Thread
public class HttpRequestHandler implements Runnable{ 
	
	static final File WEB_ROOT = new File(".");
	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
 
	
	// verbose mode
	static final boolean verbose = true;
	
	// Client Connection via Socket Class
	private Socket connect;
	
	public HttpRequestHandler(Socket c) {
		connect = c;
	}
	
 

	@Override
	public void run() {
		// we manage our particular client connection
		BufferedReader in = null; 
		PrintWriter out = null;
		BufferedOutputStream dataOut = null;
		String fileRequested = null;
		
		try {
			// we read characters from the client via input stream on the socket
			in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			// we get character output stream to client (for headers)
			out = new PrintWriter(connect.getOutputStream());
			// get binary output stream to client (for requested data)
			dataOut = new BufferedOutputStream(connect.getOutputStream());
			
			// get first line of the request from the client
			String input = in.readLine(); 
			StringBuilder requestString = new StringBuilder();
			String strCurrentLine ="";
			while ((strCurrentLine = in.readLine()) != null) {
			    System.out.println(strCurrentLine);
			    requestString.append(strCurrentLine);
			}
			
			try {
				sendPost(requestString.toString());
			} catch (Exception e) {
 				e.printStackTrace();
			}
			
			
			
			
			
			
			
			// we parse the request with a string tokenizer
			StringTokenizer parse = new StringTokenizer(input);
			String method = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
			// we get file requested
			fileRequested = parse.nextToken().toLowerCase();
			System.out.println("Request is arrived");
			// we support only GET and HEAD methods, we check
			if (method.equals("GET")  &&  method.equals("HEAD")) {
				if (verbose) {
					System.out.println("501 Not Implemented : " + method + " method.");
				}
				
				// we return the not supported file to the client
				File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
				int fileLength = (int) file.length();
				String contentMimeType = "text/html";
				//read content to return to client
				byte[] fileData = readFileData(file, fileLength);
					
				// we send HTTP Headers with data to client
				out.println("HTTP/1.1 501 Not Implemented");
				out.println("Server: Java HTTP Server from SSaurel : 1.0");
				out.println("Date: " + new Date());
				out.println("Content-type: " + contentMimeType);
				out.println("Content-length: " + fileLength);
				out.println(); // blank line between headers and content, very important !
				out.flush(); // flush character output stream buffer
				// file
				dataOut.write(fileData, 0, fileLength);
				dataOut.flush();
				
			} else {
				// GET or HEAD method
				if (fileRequested.endsWith("/")) {
					fileRequested += DEFAULT_FILE;
				}
				
				File file = new File(WEB_ROOT, fileRequested);
				int fileLength = (int) file.length();
				String content = getContentType(fileRequested);
				
				if (method.equals("GET")) { // GET method so we return content
					byte[] fileData = readFileData(file, fileLength);
					
					// send HTTP Headers
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Java HTTP Server from SSaurel : 1.0");
					out.println("Date: " + new Date());
					out.println("Content-type: " + content);
					out.println("Content-length: " + fileLength);
					out.println(); // blank line between headers and content, very important !
					out.flush(); // flush character output stream buffer
					
					dataOut.write(fileData, 0, fileLength);
					dataOut.flush();
				}
				
				if (verbose) {
					System.out.println("File " + fileRequested + " of type " + content + " returned");
				}
				
			}
			
		} catch (FileNotFoundException fnfe) {
			try {
				fileNotFound(out, dataOut, fileRequested);
			} catch (IOException ioe) {
				System.err.println("Error with file not found exception : " + ioe.getMessage());
			}
			
		} catch (IOException ioe) {
			System.err.println("Server error : " + ioe);
		} finally {
			try {
				in.close();
				out.close();
				dataOut.close();
				connect.close(); // we close socket connection
			} catch (Exception e) {
				System.err.println("Error closing stream : " + e.getMessage());
			} 
			
			if (verbose) {
				System.out.println("Connection closed.\n");
			}
		}
		
		
	}
	
	private byte[] readFileData(File file, int fileLength) throws IOException {
		FileInputStream fileIn = null;
		byte[] fileData = new byte[fileLength];
		
		try {
			fileIn = new FileInputStream(file);
			fileIn.read(fileData);
		} finally {
			if (fileIn != null) 
				fileIn.close();
		}
		
		return fileData;
	}
	
	// return supported MIME Types
	private String getContentType(String fileRequested) {
		if (fileRequested.endsWith(".htm")  ||  fileRequested.endsWith(".html"))
			return "text/html";
		else
			return "text/plain";
	}
	
	private void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException {
		File file = new File(WEB_ROOT, FILE_NOT_FOUND);
		int fileLength = (int) file.length();
		String content = "text/html";
		byte[] fileData = readFileData(file, fileLength);
		
		out.println("HTTP/1.1 404 File Not Found");
		out.println("Server: Java HTTP Server from SSaurel : 1.0");
		out.println("Date: " + new Date());
		out.println("Content-type: " + content);
		out.println("Content-length: " + fileLength);
		out.println(); // blank line between headers and content, very important !
		out.flush(); // flush character output stream buffer
		
		dataOut.write(fileData, 0, fileLength);
		dataOut.flush();
		
		if (verbose) {
			System.out.println("File " + fileRequested + " not found");
		}
	}
	
	
	private void sendPost(String xmlString) throws Exception {
		String cleanedXML = removeSoapEnvelopeAndSoapBody(xmlString);
		if(cleanedXML==null) {
			//write xmlString to file in case of data loose
		}
		PatientVitalSignDTO vitalSignDTO = XmlConverter.convertToVitalSign(cleanedXML);
		HttpPost httpPost = new HttpPost("http://localhost:8080/add-vital-sign");

		StringWriter writer = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(PatientVitalSignDTO.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(vitalSignDTO, writer);
		
		httpPost.addHeader("content-type", "application/xml");
		
		StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
		httpPost.setEntity(userEntity);
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(httpPost)) {
			System.out.println(EntityUtils.toString(response.getEntity()));
		}

	}
	
	private String removeSoapEnvelopeAndSoapBody(String xmlString) {
		try {
			SimpleXml simpleXML = new SimpleXml();
			Element element = simpleXML.fromXml(xmlString);
			return simpleXML.domToXml(element.children.get(0).children.get(0));
		} catch (IOException e) {
 			e.printStackTrace();
		}
		return null;
	}



	public static void main(String ... args) {
		HttpRequestHandler handler = new HttpRequestHandler(new Socket());
		
		XmlConverter converter = new XmlConverter();
		try {
			handler.sendPost(converter.getTestString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}