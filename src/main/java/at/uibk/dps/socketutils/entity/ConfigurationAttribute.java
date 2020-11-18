package at.uibk.dps.socketutils.entity;

/**
 * Definition of a string-string key-value pair for usage in request objects.
 * 
 * @author Fedor Smirnov TODO check how to distribute the annotator
 *         configuration between sUtils and the scheduler when implmenting the
 *         annotator module.
 *
 */
public class ConfigurationAttribute {

	protected final String key;
	protected final String value;

	public ConfigurationAttribute(final String key, final String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
