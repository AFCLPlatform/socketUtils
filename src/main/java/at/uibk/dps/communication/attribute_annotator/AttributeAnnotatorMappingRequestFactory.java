package at.uibk.dps.communication.attribute_annotator;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link AttributeAnnotatorMappingRequestFactory} is used to generate the
 * {@link AttributeAnnotatorMappingRequest} objects used for mapping queries to
 * the Attribute Annotator module.
 * 
 * @author Fedor Smirnov
 *
 */
public class AttributeAnnotatorMappingRequestFactory {

	/**
	 * Returns the request object to request the execution time of the given
	 * mapping.
	 * 
	 * @param m the given mapping
	 * @return the request object to request the execution time of the given mapping
	 */
	public static AttributeAnnotatorMappingRequest generateMappingExecTimeRequest(Mapping<Task, Resource> m) {
		return new AttributeAnnotatorMappingRequest(AttributeAnnotatorRequestType.MAPPING_EXEC_TIME_REQUEST, m);
	}
}
