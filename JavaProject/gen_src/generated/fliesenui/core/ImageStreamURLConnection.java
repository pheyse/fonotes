/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.io.ByteArrayInputStream;
/*Generated! Do not modify!*/ import java.io.ByteArrayOutputStream;
/*Generated! Do not modify!*/ import java.io.IOException;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import java.io.OutputStream;
/*Generated! Do not modify!*/ import java.net.URL;
/*Generated! Do not modify!*/ import java.net.URLConnection;
/*Generated! Do not modify!*/ public class ImageStreamURLConnection extends URLConnection {
/*Generated! Do not modify!*/     private String streamID;
/*Generated! Do not modify!*/     private FLUIImageStream imageStream;
/*Generated! Do not modify!*/     private FLUIScreenManagerInterface manager;
/*Generated! Do not modify!*/     public ImageStreamURLConnection(URL url, FLUIScreenManagerInterface manager, String streamID) {
/*Generated! Do not modify!*/         super(url);
/*Generated! Do not modify!*/         this.manager = manager;
/*Generated! Do not modify!*/         this.streamID = streamID;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void connect() throws IOException {
/*Generated! Do not modify!*/         if (connected) {
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         imageStream = manager.getCustomImageStream(streamID);
/*Generated! Do not modify!*/         connected = true;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getHeaderField(String name) {
/*Generated! Do not modify!*/         if ("Content-Type".equalsIgnoreCase(name)) {
/*Generated! Do not modify!*/             return getContentType();
/*Generated! Do not modify!*/         } else if ("Content-Length".equalsIgnoreCase(name)) {
/*Generated! Do not modify!*/             return "" + getContentLength();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return null;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getContentType() {
/*Generated! Do not modify!*/         if (imageStream == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return "image/" + imageStream.getContentType();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public int getContentLength() {
/*Generated! Do not modify!*/         return (int)imageStream.getLength();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public long getContentLengthLong() {
/*Generated! Do not modify!*/         return imageStream.getLength();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public boolean getDoInput() {
/*Generated! Do not modify!*/         return true;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public InputStream getInputStream() throws IOException {
/*Generated! Do not modify!*/         connect();
/*Generated! Do not modify!*/         if (imageStream == null){
/*Generated! Do not modify!*/             return new ByteArrayInputStream(new byte[0]);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return imageStream.getInputStream();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public OutputStream getOutputStream() throws IOException {
/*Generated! Do not modify!*/         return new ByteArrayOutputStream();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public java.security.Permission getPermission() throws IOException {
/*Generated! Do not modify!*/         return null;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 