package at.uibk.dps.communication.mapping_annotator;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link MappingAnnotatorAttributeRequest} is used as the template for the
 * Gson Object used for the queries to the attribute annotator module addressing
 * attributes of mappings..
 * 
 * @author Fedor Smirnov
 */
public class MappingAnnotatorAttributeRequest {

	protected final MappingAnnotatorRequestType requestType;
	protected final MappingStruct mapping;

	MappingAnnotatorAttributeRequest(MappingAnnotatorRequestType requestType, Mapping<Task, Resource> m) {
		this.requestType = requestType;
		this.mapping = new MappingStruct(m);
	}

	public MappingAnnotatorRequestType getRequestType() {
		return requestType;
	}

	public MappingStruct getMapping() {
		return mapping;
	}
}
