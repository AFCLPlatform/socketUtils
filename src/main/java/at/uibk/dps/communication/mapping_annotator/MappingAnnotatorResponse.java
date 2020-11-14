package at.uibk.dps.communication.mapping_annotator;

/**
 * The {@link MappingAnnotatorResponse} captures the structure of the json
 * string used to transmit the attribute response of the annotator module.
 * 
 * @author Fedor Smirnov
 *
 */
public class MappingAnnotatorResponse {

	protected final double attribute;
	protected final boolean success;
	protected final String message;

	/**
	 * Default constructor
	 * 
	 * @param attribute the attribute which was requested
	 * @param success   true iff exchange successful
	 * @param message   optional message string
	 */
	public MappingAnnotatorResponse(final double attribute, final boolean success, final String message) {
		this.attribute = attribute;
		this.success = success;
		this.message = message;
	}

	public double getAttribute() {
		return attribute;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
