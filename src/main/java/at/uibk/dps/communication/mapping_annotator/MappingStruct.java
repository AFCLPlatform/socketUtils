package at.uibk.dps.communication.mapping_annotator;

import java.util.HashMap;
import java.util.Map;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link MappingStruct} is captures the structure of the JSON which is used
 * to transmit information about individual mappings between the modules.
 * 
 * @author Fedor Smirnov
 */
public class MappingStruct {

	protected final String mappingId;
	protected final Map<String, Object> mappingAttributes;

	protected final String sourceId;
	protected final Map<String, Object> sourceAttributes;

	protected final String targetId;
	protected final Map<String, Object> targetAttributes;

	public MappingStruct(Mapping<Task, Resource> m) {
		this.mappingId = m.getId();
		this.mappingAttributes = new HashMap<>(); 
		for (String attrName : m.getAttributeNames()) {
			mappingAttributes.put(attrName, m.getAttribute(attrName));
		}
		Task src = m.getSource();
		this.sourceId = src.getId();
		this.sourceAttributes = new HashMap<>();
		for (String attrName : src.getAttributeNames()) {
			sourceAttributes.put(attrName, src.getAttribute(attrName));
		}
		Resource trg = m.getTarget();
		this.targetId = trg.getId();
		this.targetAttributes = new HashMap<>();
		for (String attrName : trg.getAttributeNames()) {
			targetAttributes.put(attrName, trg.getAttribute(attrName));
		}
	}

	public String getMappingId() {
		return mappingId;
	}

	public Map<String, Object> getMappingAttributes() {
		return mappingAttributes;
	}

	public String getSourceId() {
		return sourceId;
	}

	public Map<String, Object> getSourceAttributes() {
		return sourceAttributes;
	}

	public String getTargetId() {
		return targetId;
	}

	public Map<String, Object> getTargetAttributes() {
		return targetAttributes;
	}

}
