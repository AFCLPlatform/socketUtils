package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.ConfigurationAttribute;
import at.uibk.dps.socketutils.mapping_annotator.RequestMappingAnnotator.RequestType;
import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

public class UtilsSocketMappingAnnotatorTest {

	@Test
	public void testReqExecTime() {
		Task t = new Task("t");
		var res = new Resource("res");
		var m = new Mapping<Task, Resource>("m", t, res);
		RequestMappingAnnotatorAttribute result = UtilsSocketMappingAnnotator.generateRequestExecTime(m);
		assertEquals(RequestType.MAPPING_EXEC_TIME_REQUEST, result.getRequestType());
	}

	@Test
	public void testRequestInit() {
		var typeMock1 = mock(RequestType.class);
		var typeList = new HashSet<>(Arrays.asList(typeMock1));

		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m1 = new Mapping<Task, Resource>("m1", t, res);
		Set<Mapping<Task, Resource>> mList = new HashSet<>(Arrays.asList(m1));

		Set<ConfigurationAttribute> attrSet = new HashSet<>();
		ConfigurationAttribute att = new ConfigurationAttribute("key", "value");
		attrSet.add(att);

		RequestMappingAnnotatorInit result = UtilsSocketMappingAnnotator.generateRequestInit(typeList, mList, attrSet);

		assertEquals(typeMock1, result.getRequestTypes().get(0));
		assertEquals(m1.getId(), result.getMappings().get(0).getMappingId());
		assertEquals(att.getValue(), result.getConfigurationAttributes().values().iterator().next());
	}
}
