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

	/**
	 * Creates a struct based on the given mapping.
	 * 
	 * @param mapping the given mapping
	 */
	protected MappingStruct(final Mapping<Task, Resource> mapping) {
		this.mappingId = mapping.getId();
		this.mappingAttributes = new HashMap<>();
		for (final String attrName : mapping.getAttributeNames()) {
			mappingAttributes.put(attrName, mapping.getAttribute(attrName));
		}
		final Task src = mapping.getSource();
		this.sourceId = src.getId();
		this.sourceAttributes = new HashMap<>();
		for (final String attrName : src.getAttributeNames()) {
			sourceAttributes.put(attrName, src.getAttribute(attrName));
		}
		final Resource trg = mapping.getTarget();
		this.targetId = trg.getId();
		this.targetAttributes = new HashMap<>();
		for (final String attrName : trg.getAttributeNames()) {
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
	public boolean equals(final Object obj) {
		if (!(obj instanceof MappingStruct)) {
			return false;
		}
		final MappingStruct other = (MappingStruct) obj;
		boolean equal = other.getTargetId().equals(targetId);
		equal &= other.getSourceId().equals(sourceId);
		equal &= other.getMappingAttributes().equals(mappingAttributes);
		equal &= other.getMappingId().equals(mappingId);
		equal &= other.getSourceAttributes().equals(sourceAttributes);
		equal &= other.getTargetAttributes().equals(targetAttributes);
		return equal;
	}

}
