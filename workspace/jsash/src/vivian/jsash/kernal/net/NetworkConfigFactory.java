package vivian.jsash.kernal.net;

import java.util.Properties;

import vivian.jsash.kernal.common.Configuration;
import vivian.jsash.kernal.net.config.NetworkConfig;

/**
 * A class of configuration creator in factory mode.
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public class NetworkConfigFactory {
	
	/**
	 * An enumeration of configuration type.
	 */
	public enum ConfigurationType {
		NetworkConfig,
	}
	
	private static NetworkConfig config = null;
	
	/**
	 * get a configuration's instance.
	 * @param type Configuration type.
	 * @param prop Properties.
	 * @return instance of configuration.
	 */
	public static Configuration getConfiguration( ConfigurationType type, Properties prop ) {
		switch( type ) {
		case NetworkConfig:
			if( config == null ) {
				config = new NetworkConfig();
				config.fromProperties(prop);
			}
			return config;
		}
		return null;
	}
	
	/**
	 * Create a configuration's instance.
	 * @param type Configuration type.
	 * @param prop Properties.
	 * @return instance of configuration.
	 */
	public static Configuration CreateConfiguration( ConfigurationType type, Properties prop ) {
		switch( type ) {
		case NetworkConfig:
			config = new NetworkConfig();
			config.fromProperties(prop);
			return config;
		}
		return null;
	}

}
