package at.uibk.dps.socketutils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import at.uibk.dps.socketutils.testconstants.ConstantsTestSocketUtils;

public class UtilsSocketTest {

	@Test
	public void testReadFileToBytes() {
		final byte[] result;
		try {
			result = UtilsSocket.readFileToBytes(ConstantsTestSocketUtils.filePathReadTestFile);
			assertTrue(Arrays.equals(ConstantsTestSocketUtils.expectedByteValue, result));
		} catch (IOException exc) {
			fail("IOException when testing file to byte reading.");
		}
	}
}
