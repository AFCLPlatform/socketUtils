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

	protected MappingStruct(Mapping<Task, Resource> m) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mappingAttributes == null) ? 0 : mappingAttributes.hashCode());
		result = prime * result + ((mappingId == null) ? 0 : mappingId.hashCode());
		result = prime * result + ((sourceAttributes == null) ? 0 : sourceAttributes.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((targetAttributes == null) ? 0 : targetAttributes.hashCode());
		result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MappingStruct other = (MappingStruct) obj;
		if (mappingAttributes == null) {
			if (other.mappingAttributes != null)
				return false;
		} else if (!mappingAttributes.equals(other.mappingAttributes))
			return false;
		if (mappingId == null) {
			if (other.mappingId != null)
				return false;
		} else if (!mappingId.equals(other.mappingId))
			return false;
		if (sourceAttributes == null) {
			if (other.sourceAttributes != null)
				return false;
		} else if (!sourceAttributes.equals(other.sourceAttributes))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (targetAttributes == null) {
			if (other.targetAttributes != null)
				return false;
		} else if (!targetAttributes.equals(other.targetAttributes))
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
			return false;
		return true;
	}
	
	

}
