package vivian.jsash.kernal.net.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * An message of http request.
 * @author vivian
 * @version 1.0
 * @since 2010/07/04
 */
public class HttpRequestMessage {
    
    private Map<String, String[]> headers = new HashMap<String, String[]>();

    public void setHeaders(Map<String, String[]> headers) {
        this.headers.putAll(headers);
    }

    public Map<String, String[]> getHeaders() {
        return headers;
    }
    
    public void setContext(String context) {
        this.headers.put("Context", new String[]{context});
    }

    public String getContext() {
        String[] context = headers.get("Context");
        return context == null ? "" : context[0];
    }

    public String getParameter(String name) {
        String[] param = headers.get("@".concat(name));
        return param == null ? "" : param[0];
    }

    public String[] getParameters(String name) {
        String[] param = headers.get("@".concat(name));
        return param == null ? new String[] {} : param;
    }

    public String[] getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Entry<String, String[]> e: headers.entrySet()) {
            str.append(e.getKey() + " : "
                    + arrayToString(e.getValue(), ',') + "\n");
        }
        return str.toString();
    }

    public static String arrayToString(String[] s, char sep) {
        if (s == null || s.length == 0) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                if (i > 0) {
                    buf.append(sep);
                }
                buf.append(s[i]);
            }
        }
        return buf.toString();
    }
}