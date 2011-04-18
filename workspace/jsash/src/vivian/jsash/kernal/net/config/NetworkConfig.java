package vivian.jsash.kernal.net.config;

import java.util.Properties;

import vivian.jsash.kernal.common.Configuration;

/**
 * An implement of configuration about network.
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public class NetworkConfig implements Configuration {
	
	private String destUrl;
	
	private int destPort;
	
	private String sourceUrl;
	
	private int sourcePort;
	
	private boolean isBlocking;
	
	private int timeout;

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestPort(int destPort) {
		this.destPort = destPort;
	}

	public int getDestPort() {
		return destPort;
	}

	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}
	
	@Override
	public void fromProperties( Properties prop ) {
		destUrl = prop.getProperty( NetworkStringContext.DEST_URL );
		destPort = Integer.parseInt(prop.getProperty( NetworkStringContext.DEST_PORT, "10229" ));
		sourceUrl = prop.getProperty( NetworkStringContext.SOURCE_URL, "localhost" );
		sourcePort = Integer.parseInt(prop.getProperty( NetworkStringContext.SOURCE_PORT, "10228" ));
		String blocking = prop.getProperty( NetworkStringContext.BLOCKING, "0" ).toLowerCase();
		if( blocking.equals("true") || blocking.equals("yes") || blocking.equals("1") ) {
			isBlocking = true;
		} else {
			isBlocking = false;
		}
		timeout = Integer.parseInt(prop.getProperty( NetworkStringContext.TIMEOUT, "30000" ));
	}

}
