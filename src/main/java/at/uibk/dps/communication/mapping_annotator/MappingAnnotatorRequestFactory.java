package at.uibk.dps.communication.mapping_annotator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link MappingAnnotatorRequestFactory} is used to generate the
 * {@link MappingAnnotatorAttributeRequest} objects used for mapping queries to
 * the Attribute Annotator module.
 * 
 * @author Fedor Smirnov
 *
 */
public class MappingAnnotatorRequestFactory {

	/**
	 * Returns the request object to request the execution time of the given
	 * mapping.
	 * 
	 * @param m the given mapping
	 * @return the request object to request the execution time of the given mapping
	 */
	public static MappingAnnotatorAttributeRequest generateMappingExecTimeRequest(Mapping<Task, Resource> m) {
		return new MappingAnnotatorAttributeRequest(MappingAnnotatorRequestType.MAPPING_EXEC_TIME_REQUEST, m);
	}

	/**
	 * Returns the request object for the initiation of the (dynamic) mapping annotation by the annotator.
	 * 
	 * @param requestTypes the types of requests which are expected
	 * @param mappings the mappings which will be requested
	 * @return the request object for the init
	 */
	public static MappingAnnotatorInitRequest generateMappingInitRequest(Set<MappingAnnotatorRequestType> requestTypes,
			Set<Mapping<Task, Resource>> mappings) {
		List<MappingAnnotatorRequestType> typeList = new ArrayList<>(requestTypes);
		List<MappingStruct> mappingList = new ArrayList<>();
		for (Mapping<Task, Resource> m : mappings) {
			mappingList.add(new MappingStruct(m));
		}
		return new MappingAnnotatorInitRequest(MappingAnnotatorRequestType.INIT_REQUEST, typeList, mappingList);
	}
}
