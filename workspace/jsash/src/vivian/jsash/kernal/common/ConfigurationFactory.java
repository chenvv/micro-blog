package vivian.jsash.kernal.common;

/**
 * An interface of configuration creator in factory mode.
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public interface ConfigurationFactory {
	public Configuration createConfiguration( String name );
}
