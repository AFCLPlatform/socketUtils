package at.uibk.dps.communication.mapping_annotator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import net.sf.opendse.model.Mapping;
import net.sf.opendse.model.Resource;
import net.sf.opendse.model.Task;

public class MappingStructTest {

	/**
	 * Test for the practical usage of the equals method
	 */
	@Test
	public void testEquals() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		MappingStruct tested1 = new MappingStruct(m);
		MappingStruct tested2 = new MappingStruct(m);
		assertEquals(tested1, tested2);
	}

	@Test
	public void testGetMappingId() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		MappingStruct tested = new MappingStruct(m);
		assertEquals("m", tested.getMappingId());
	}

	@Test
	public void testGetSourceId() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		MappingStruct tested = new MappingStruct(m);
		assertEquals("t", tested.getSourceId());
	}

	@Test
	public void testGetTargetId() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		MappingStruct tested = new MappingStruct(m);
		assertEquals("r", tested.getTargetId());
	}

	@Test
	public void testGetMappingAttributes() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		m.setAttribute("attr1", 1);
		m.setAttribute("attr2", 13.);
		MappingStruct tested = new MappingStruct(m);
		Map<String, Object> result = tested.getMappingAttributes();
		assertTrue(result.containsKey("attr1"));
		assertTrue(result.containsKey("attr2"));
		assertEquals(result.get("attr1"), 1);
		assertEquals((double) result.get("attr2"), 13., 0.0);
	}

	@Test
	public void testGetSourceAttributes() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		t.setAttribute("attr1", 1);
		t.setAttribute("attr2", 13.);
		MappingStruct tested = new MappingStruct(m);
		Map<String, Object> result = tested.getSourceAttributes();
		assertTrue(result.containsKey("attr1"));
		assertTrue(result.containsKey("attr2"));
		assertEquals(result.get("attr1"), 1);
		assertEquals((double) result.get("attr2"), 13., 0.0);
	}

	@Test
	public void testGetTargetAttributes() {
		Task t = new Task("t");
		Resource res = new Resource("r");
		Mapping<Task, Resource> m = new Mapping<Task, Resource>("m", t, res);
		res.setAttribute("attr1", 1);
		res.setAttribute("attr2", 13.);
		MappingStruct tested = new MappingStruct(m);
		Map<String, Object> result = tested.getTargetAttributes();
		assertTrue(result.containsKey("attr1"));
		assertTrue(result.containsKey("attr2"));
		assertEquals(result.get("attr1"), 1);
		assertEquals((double) result.get("attr2"), 13., 0.0);
	}

}
