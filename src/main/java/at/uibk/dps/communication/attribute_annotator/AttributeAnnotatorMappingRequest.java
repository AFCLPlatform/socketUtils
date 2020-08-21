package at.uibk.dps.communication.attribute_annotator;

import java.util.HashMap;
import java.util.Map;

import at.uibk.dps.communication.entity.AttributeAnnotatorRequestType;
import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

/**
 * The {@link AttributeAnnotatorMappingRequest} is used as the template for the
 * Gson Object used for the queries to the attribute annotator module addressing
 * attributes of mappings..
 * 
 * @author Fedor Smirnov
 */
public class AttributeAnnotatorMappingRequest {

	protected final AttributeAnnotatorRequestType requestType;
	
	protected final String mappingId;
	protected final Map<String, Object> mappingAttributes;

	protected final String sourceId;
	protected final Map<String, Object> sourceAttributes;

	protected final String targetId;
	protected final Map<String, Object> targetAttributes;

	AttributeAnnotatorMappingRequest(AttributeAnnotatorRequestType requestType, Mapping<Task, Resource> m) {
		this.requestType = requestType;
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
	
	public AttributeAnnotatorRequestType getRequestType() {
		return requestType;
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
