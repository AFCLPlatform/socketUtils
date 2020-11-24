package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.mapping_annotator.RequestMappingAnnotator.RequestType;
import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

import static org.mockito.Mockito.mock;

public class RequestMappingAnnotatorAttributeTest {

	@Test
	public void test() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		RequestType typeMock = mock(RequestType.class);
		RequestMappingAnnotatorAttribute tested = new RequestMappingAnnotatorAttribute(typeMock, m);
		assertEquals(typeMock, tested.getRequestType());
		assertEquals(m.getId(), tested.getMapping().getMappingId());
	}

}
