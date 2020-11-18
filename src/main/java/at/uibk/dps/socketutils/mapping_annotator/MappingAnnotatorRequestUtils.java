package at.uibk.dps.socketutils.mapping_annotator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import at.uibk.dps.socketutils.entity.ConfigurationAttribute;
import at.uibk.dps.socketutils.mapping_annotator.MappingAnnotatorRequest.RequestType;
import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link MappingAnnotatorRequestUtils} is used to generate the
 * {@link MappingAnnotatorAttributeRequest} objects used for mapping queries to
 * the Attribute Annotator module.
 * 
 * @author Fedor Smirnov
 *
 */
public final class MappingAnnotatorRequestUtils {

	/**
	 * 
	 * Area for the declarations concerning the execution time requests.
	 *
	 */

	/**
	 * The type of the regressor used for the exec time prediction.
	 * 
	 * @author Fedor Smirnov
	 */
	public enum RegressorType {
		DECISION_TREE, KNN, RANDOM_FOREST
	}

	/**
	 * The way of calculating the time (just the start time vs. sum of start and
	 * execution time).
	 * 
	 * @author Fedor Smirnov
	 */
	public enum CalculationTypeExecTime {
		START_TIME, SUM
	}

	public static final String ATTR_NAME_ACTIVE_FUNCTION_PREDICTOR = "Active function predictor";
	public static final String ATTR_NAME_RTT_PREDICTOR = "Rtt predictor";
	public static final String ATTR_NAME_START_TIME_PREDICTOR = "Start time predictor";
	public static final String ATTR_NAME_CALCULATION_TYPE_EXEC_TIME = "calculation type";

	/**
	 * Default constructor.
	 */
	private MappingAnnotatorRequestUtils() {
	}

	/**
	 * Returns the request object to request the execution time of the given
	 * mapping.
	 * 
	 * @param mapping the given mapping
	 * @return the request object to request the execution time of the given mapping
	 */
	public static MappingAnnotatorAttributeRequest generateMappingExecTimeRequest(final Mapping<Task, Resource> mapping) {
		return new MappingAnnotatorAttributeRequest(RequestType.MAPPING_EXEC_TIME_REQUEST, mapping);
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
	public static MappingAnnotatorInitRequest generateMappingInitRequest(final Set<RequestType> requestTypes,
			final Set<Mapping<Task, Resource>> mappings, final Set<ConfigurationAttribute> configAttributes) {
		final List<RequestType> typeList = new ArrayList<>(requestTypes);
		final  List<MappingStruct> mappingList = new ArrayList<>();
		for (Mapping<Task, Resource> m : mappings) {
			mappingList.add(new MappingStruct(m));
		}
		final Map<String, String> configMap = new ConcurrentHashMap<>();
		for (final ConfigurationAttribute confAttr : configAttributes) {
			configMap.put(confAttr.getKey(), confAttr.getValue());
		}
		return new MappingAnnotatorInitRequest(typeList, mappingList,
				configMap);
	}
}
