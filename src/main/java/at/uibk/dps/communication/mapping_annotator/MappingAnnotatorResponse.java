package at.uibk.dps.communication.mapping_annotator;

/**
 * The {@link MappingAnnotatorResponse} captures the structure of the json
 * string used to transmit the attribute response of the annotator module.
 * 
 * @author Fedor Smirnov
 *
 */
public class MappingAnnotatorResponse {

	protected final double requestedValue;
	protected final boolean success;
	protected final String excMessage;

	public MappingAnnotatorResponse(double attribute, boolean success, String message) {
		this.requestedValue = attribute;
		this.success = success;
		this.excMessage = message;
	}

	public double getAttribute() {
		return requestedValue;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return excMessage;
	}
}
