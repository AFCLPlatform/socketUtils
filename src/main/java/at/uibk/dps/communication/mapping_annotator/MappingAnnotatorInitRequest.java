package at.uibk.dps.communication.mapping_annotator;

import java.util.List;

/**
 * The mapping {@link MappingAnnotatorInitRequest} is used to inform the
 * MappingAnnotator about the resource links relevant for the upcoming
 * orchestration, as well as about the request types that are expected to occur
 * therein.
 */
public class MappingAnnotatorInitRequest {

	protected final List<MappingAnnotatorRequestType> requestTypes;
	protected final List<MappingStruct> mappings;

	protected MappingAnnotatorInitRequest(List<MappingAnnotatorRequestType> requestTypes, List<MappingStruct> mappings) {
		this.requestTypes = requestTypes;
		this.mappings = mappings;
	}

	public List<MappingAnnotatorRequestType> getRequestTypes() {
		return requestTypes;
	}

	public List<MappingStruct> getMappings() {
		return mappings;
	}
}
