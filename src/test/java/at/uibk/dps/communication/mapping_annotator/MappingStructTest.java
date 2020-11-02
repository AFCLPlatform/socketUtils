package at.uibk.dps.communication.mapping_annotator;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

public class MappingStructTest {

	@Test
	public void testGetMappingId() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		MappingStruct tested = new MappingStruct(m);
		assertEquals("m", tested.getMappingId());
	}

}
