package vivian.jsash.kernal.net.http;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * A message of http response.
 * @author vivian
 * @version 1.0
 * @since 2010/07/04
 */
public class HttpResponseMessage {
    /** HTTP response codes */
    public static final int HTTP_STATUS_SUCCESS = 200;

    public static final int HTTP_STATUS_NOT_FOUND = 404;
    
    public static final int HTTP_STATUS_INTERNAL_ERROR  = 500;
    
    public static final int HTTP_STATUS_NOT_IMPLEMENTED = 501;
    

    /** Map<String, String> */
    private final Map<String, String> headers = new HashMap<String, String>();

    /** Storage for body of HTTP response. */
    private final ByteArrayOutputStream body = new ByteArrayOutputStream(1024);

    private int responseCode = HTTP_STATUS_SUCCESS;

    public HttpResponseMessage() {
//        headers.put("Server", "MicroBlog");
        headers.put("Cache-Control", "private");
        headers.put("Content-Type", "text/html; charset=UTF-8");
        headers.put("Connection", "keep-alive");
        headers.put("Keep-Alive", "200");
        headers.put("Date", new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss zzz").format(new Date()));
        headers.put("Last-Modified", new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss zzz").format(new Date()));
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setContentType(String contentType) {
        headers.put("Content-Type", contentType);
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void appendBody(byte[] b) {
        try {
            body.write(b);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void appendBody(String s) {
        try {
            body.write(s.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IoBuffer getBody() {
        return IoBuffer.wrap(body.toByteArray());
    }

    public int getBodyLength() {
        return body.size();
    }
}