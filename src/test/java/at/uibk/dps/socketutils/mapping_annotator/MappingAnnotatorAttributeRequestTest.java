package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.uibk.dps.socketutils.mapping_annotator.MappingAnnotatorRequest.RequestType;
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
		RequestType typeMock = mock(RequestType.class);
		MappingAnnotatorRequestAttribute tested = new MappingAnnotatorRequestAttribute(typeMock, m);
		assertEquals(typeMock, tested.getRequestType());
	}
	
	@Test
	public void testGetMapping() {
		Task t = new Task("t");
		Resource r = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, r);
		RequestType typeMock = mock(RequestType.class);
		MappingAnnotatorRequestAttribute tested = new MappingAnnotatorRequestAttribute(typeMock, m);
		assertEquals(new MappingStruct(m), tested.getMapping());
	}
}
