package com.bright_side_it.fonotes.android.service;

import android.content.Context;
import android.util.Log;

import com.bright_side_it.fonotes.common.base.NetworkUtil;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import generated.fliesenui.core.FLUIScreenManagerAndroid;
import generated.fliesenui.core.FLUIWebCall;
import generated.fliesenui.core.FLUIWebCallHandler;

/**
 * Created by me on 03.11.2016.
 */

public class FonotesAndroidJettyServer extends AbstractHandler {
	private final FLUIScreenManagerAndroid screenManager;
	private Server server;
	private FLUIWebCallHandler fliesenUIWebCallHandler;
	private Context context;
	private int port;

	public FonotesAndroidJettyServer(Context context, int port, FLUIScreenManagerAndroid screenManager){
		this.context = context;
		this.port = port;
		this.screenManager = screenManager;
	}

	public void handle(String target, Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
		baseRequest.setHandled(true);
		response.setStatus(HttpServletResponse.SC_OK);
		FLUIWebCall webCall = new FLUIWebCall() {
			@Override
			public void log(String message) {
				System.out.println("webCall> " + message);
			}
			@Override
			public void setReponseContentLength(long length) {
				response.setContentLength((int)length);
			}
			@Override
			public void setResponseContentType(String contentType) {
				response.setContentType(contentType);
			}
			@Override
			public OutputStream getResponseOutputStream() throws Exception{
				return response.getOutputStream();
			}
			@Override
			public InputStream getRequestInputStream() throws Exception {
				return request.getInputStream();
			}
			@Override
			public long getRequestContentLength() {
				return request.getContentLength();
			}
			@Override
			public void setReponseHeader(String name, String value) {
				response.setHeader(name, value);
			}
		};

		try {
			screenManager.handleWebCall(webCall, request.getMethod(), request.getPathInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIPAddressInfoString(int port){
		List<String> externalIPAddresses = NetworkUtil.getIPAddresses(NetworkUtil.IPAddressType.IPV4, true, false);
		StringBuilder sb = new StringBuilder("IPV4-Addresses: ");
		boolean first = true;
		for (String i: externalIPAddresses){
			if (first){
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append("'" + i + ":" + port + "'");
		}
		return sb.toString();
	}

	public void startServer() throws Exception {
		logIPAddresses();

		new Thread(){
			@Override
			public void run() {
				log("starting...");
				server = new Server(port);
				server.setHandler(new FonotesAndroidJettyServer(context, port, screenManager));
				try {
					server.start();
					server.join();
				} catch (Exception e) {
					e.printStackTrace();
					log("Error while starting server: " + e);
				}
			}
		}.start();
	}

	private void logIPAddresses() {
		List<String> externalIPAddresses = NetworkUtil.getIPAddresses(NetworkUtil.IPAddressType.IPV4, true, false);
		log("IP addresses:");
		for (String i: externalIPAddresses){
			log(" - " + i);
		}
	}

	private void log(String message) {
		Log.d("jettypoc: CMJettyServer", message);
	}

	public void stopServer() throws Exception {
		if (server != null){
			server.stop();
			server = null;
		}
	}
}
