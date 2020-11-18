package at.uibk.dps.socketutils.mapping_annotator;

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
public class MappingAnnotatorAttributeRequest extends MappingAnnotatorRequest{

	protected final MappingStruct mapping;

	MappingAnnotatorAttributeRequest(RequestType requestType, Mapping<Task, Resource> m) {
		super(requestType);
		this.mapping = new MappingStruct(m);
	}

	public MappingStruct getMapping() {
		return mapping;
	}
}
