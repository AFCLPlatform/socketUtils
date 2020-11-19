package at.uibk.dps.socketutils.mapping_annotator;

import java.util.List;
import java.util.Map;

/**
 * The mapping {@link RequestMappingAnnotatorInit} is used to inform the
 * MappingAnnotator about the resource links relevant for the upcoming
 * orchestration, as well as about the request types that are expected to occur
 * therein.
 * 
 * @author Fedor Smirnov
 */
public class RequestMappingAnnotatorInit extends RequestMappingAnnotator{

	protected final List<RequestType> requestTypes;
	protected final List<MappingStruct> mappings;
	protected final Map<String, String> configurationAttributes;

	/**
	 * Default constructor
	 * 
	 * @param requestTypes            the types of requests that the annotator shall
	 *                                expect
	 * @param mappings                the mappings that the requests will relate to
	 * @param configurationAttributes additional config attributes
	 */
	protected RequestMappingAnnotatorInit(final List<RequestType> requestTypes, final List<MappingStruct> mappings,
			final Map<String, String> configurationAttributes) {
		super(RequestType.INIT_REQUEST);
		this.requestTypes = requestTypes;
		this.mappings = mappings;
		this.configurationAttributes = configurationAttributes;
	}

	public List<RequestType> getRequestTypes() {
		return requestTypes;
	}

	public List<MappingStruct> getMappings() {
		return mappings;
	}

	public Map<String, String> getConfigurationAttributes() {
		return configurationAttributes;
	}

	public RequestType getRequestType() {
		return requestType;
	}
}
