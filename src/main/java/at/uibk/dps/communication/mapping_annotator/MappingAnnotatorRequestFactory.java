package at.uibk.dps.communication.mapping_annotator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import at.uibk.dps.communication.entity.ConfigurationAttribute;
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
	 * 
	 * Area for the declarations concerning the execution time requests.
	 *
	 */

	public enum RegressorType {
		DECISION_TREE, KNN, RANDOM_FOREST
	}
	
	public enum CalculationTypeExecTime{
		START_TIME, SUM
	}

	public static final String ATTR_NAME_ACTIVE_FUNCTION_PREDICTOR = "Active function predictor";
	public static final String ATTR_NAME_RTT_PREDICTOR = "Rtt predictor";
	public static final String ATTR_NAME_START_TIME_PREDICTOR = "Start time predictor";
	public static final String ATTR_NAME_CALCULATION_TYPE_EXEC_TIME = "calculation type";

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
	 * 
	 * Area for the declarations concerning the init requests.
	 *
	 */

	/**
	 * Returns the request object for the initiation of the (dynamic) mapping
	 * annotation by the annotator.
	 * 
	 * @param requestTypes the types of requests which are expected
	 * @param mappings     the mappings which will be requested
	 * @return the request object for the init
	 */
	public static MappingAnnotatorInitRequest generateMappingInitRequest(Set<MappingAnnotatorRequestType> requestTypes,
			Set<Mapping<Task, Resource>> mappings, Set<ConfigurationAttribute> configAttributes) {
		List<MappingAnnotatorRequestType> typeList = new ArrayList<>(requestTypes);
		List<MappingStruct> mappingList = new ArrayList<>();
		for (Mapping<Task, Resource> m : mappings) {
			mappingList.add(new MappingStruct(m));
		}
		Map<String, String> configMap = new HashMap<>();
		for (ConfigurationAttribute confAttr : configAttributes) {
			configMap.put(confAttr.getKey(), confAttr.getValue());
		}
		return new MappingAnnotatorInitRequest(MappingAnnotatorRequestType.INIT_REQUEST, typeList, mappingList,
				configMap);
	}
}
