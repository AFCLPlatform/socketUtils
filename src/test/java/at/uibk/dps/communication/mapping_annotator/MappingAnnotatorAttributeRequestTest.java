package at.uibk.dps.communication.mapping_annotator;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

import static org.mockito.Mockito.mock;

public class MappingAnnotatorAttributeRequestTest {

	@Test
	public void testGetRequestType() {
		Task t = new Task("t");
		Resource r = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, r);
		MappingAnnotatorRequestType typeMock = mock(MappingAnnotatorRequestType.class);
		MappingAnnotatorAttributeRequest tested = new MappingAnnotatorAttributeRequest(typeMock, m);
		assertEquals(typeMock, tested.getRequestType());
	}
	
	@Test
	public void testGetMapping() {
		Task t = new Task("t");
		Resource r = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, r);
		MappingAnnotatorRequestType typeMock = mock(MappingAnnotatorRequestType.class);
		MappingAnnotatorAttributeRequest tested = new MappingAnnotatorAttributeRequest(typeMock, m);
		assertEquals(new MappingStruct(m), tested.getMapping());
	}
}
