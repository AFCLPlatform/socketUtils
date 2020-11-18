package at.uibk.dps.socketutils.mapping_annotator;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link MappingAnnotatorRequestAttribute} is used as the template for the
 * Gson Object used for the queries to the attribute annotator module addressing
 * attributes of mappings..
 * 
 * @author Fedor Smirnov
 */
public class MappingAnnotatorRequestAttribute extends MappingAnnotatorRequest {

	protected final MappingStruct mapping;

	protected MappingAnnotatorRequestAttribute(final RequestType requestType, final Mapping<Task, Resource> mapping) {
		super(requestType);
		this.mapping = new MappingStruct(mapping);
	}

	public MappingStruct getMapping() {
		return mapping;
	}
}
