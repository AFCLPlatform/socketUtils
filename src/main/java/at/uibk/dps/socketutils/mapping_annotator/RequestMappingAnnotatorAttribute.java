package at.uibk.dps.socketutils.mapping_annotator;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link RequestMappingAnnotatorAttribute} is used as the template for the
 * Gson Object used for the queries to the attribute annotator module addressing
 * attributes of mappings.
 * 
 * @author Fedor Smirnov
 */
public class RequestMappingAnnotatorAttribute extends RequestMappingAnnotator {

	/**
	 * The mapping of tasks and resources.
	 */
	protected final MappingStruct mapping;

	/**
	 * Template for the query to the attribute annotator.
	 *
	 * @param requestType type of the request.
	 * @param mapping of task and resources.
	 */
	protected RequestMappingAnnotatorAttribute(final RequestType requestType, final Mapping<Task, Resource> mapping) {
		super(requestType);
		this.mapping = new MappingStruct(mapping);
	}

	public MappingStruct getMapping() {
		return mapping;
	}
}
