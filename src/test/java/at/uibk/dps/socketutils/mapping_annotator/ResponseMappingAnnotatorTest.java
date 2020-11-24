package at.uibk.dps.socketutils.mapping_annotator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResponseMappingAnnotatorTest {

	@Test
	public void test() {
		double attribute = 42.;
		boolean success = true;
		String message = "okay";

		ResponseMappingAnnotator tested = new ResponseMappingAnnotator(attribute, success, message);
		assertEquals(attribute, tested.getAttribute(), 0.0);
		assertEquals(success, tested.isSuccess());
		assertEquals(message, tested.getMessage());
	}
}
