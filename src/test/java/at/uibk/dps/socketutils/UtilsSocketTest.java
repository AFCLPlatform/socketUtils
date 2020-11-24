package at.uibk.dps.socketutils;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.junit.Test;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.testconstants.ConstantsTestSocketUtils;

public class UtilsSocketTest {

	@Test
	public void testSendBytes() {
		OutputStream testOutput = new ByteArrayOutputStream();
		String myMessage = "hi";
		byte[] byteMessage = myMessage.getBytes();
		try {
			UtilsSocket.sendBytes(testOutput, byteMessage);
			assertEquals(myMessage, testOutput.toString());
		} catch (IOException ioExc) {
			fail("IOException");
		}
	}

	@Test
	public void testSendJsonObject() {
		JsonObject jsonMock = new JsonObject();
		jsonMock.addProperty("key", "value");
		OutputStream testOutput = new ByteArrayOutputStream();
		String expectedOutput = "{\"key\":\"value\"}";
		try {
			UtilsSocket.sendJsonObject(testOutput, jsonMock);
			assertEquals(expectedOutput + ConstantsNetwork.MESSAGE_TERMINATION_STRING, testOutput.toString());
		} catch (IOException ioExc) {
			fail("IOException");
		}
	}

	@Test
	public void testSendJsonString() {
		OutputStream testOutput = new ByteArrayOutputStream();
		String jsonString = "output";
		try {
			UtilsSocket.sendJsonString(testOutput, jsonString);
			assertEquals(jsonString + ConstantsNetwork.MESSAGE_TERMINATION_STRING, testOutput.toString());
		} catch (IOException ioExc) {
			fail("IOException when testing the sending of the Json string.");
		}
	}

	@Test
	public void testReceiveJsonString() {
		String input = "jsonString";
		byte[] byteInput = (input + ConstantsNetwork.MESSAGE_TERMINATION_STRING).getBytes();
		InputStream inputStream = new ByteArrayInputStream(byteInput);
		try {
			String result = UtilsSocket.receiveJsonString(inputStream);
			assertEquals(input, result);
		} catch (IOException ioExc) {
			fail("IOException when testing the receiving of the Json string.");
		}
	}
	
	@Test
	public void testReceiveJsonObject() {
		JsonObject jsonMock = new JsonObject();
		jsonMock.addProperty("key", "value");
		byte[] byteInput = (jsonMock.toString() + ConstantsNetwork.MESSAGE_TERMINATION_STRING).getBytes();
		InputStream inputStream = new ByteArrayInputStream(byteInput);
		try {
			JsonObject result = UtilsSocket.receiveJsonObject(inputStream);
			assertEquals("{\"key\":\"value\"}", result.toString());
		} catch (IOException ioExc) {
			fail("IOExecption when testing the receiving of the Json string.");
		}
	}

	@Test
	public void testReceiveBytesAndWrite() {
		String input = "input";
		byte[] byteInput = input.getBytes();
		InputStream testInputStream = new ByteArrayInputStream(byteInput);
		try {
			String fileToWrite = ConstantsTestSocketUtils.filePathWriteTestFile;
			UtilsSocket.receiveBytesAndWriteToFile(testInputStream, fileToWrite);
			assertTrue(Arrays.equals(byteInput, UtilsSocket.readFileToBytes(fileToWrite)));
			// delete the file
			File file = new File(ConstantsTestSocketUtils.filePathWriteTestFile);
			file.delete();
		} catch (IOException ioExc) {
			fail("IOException while receiving and writing bytes.");
		}
	}

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

	@Test
	public void testEndStringCheck() {
		String wrong1 = "wrong";
		String wrong2 = "";
		String right = wrong1 + ConstantsNetwork.MESSAGE_TERMINATION_STRING;
		assertTrue(UtilsSocket.checkMessageEnd(new StringBuffer(right)));
		assertFalse(UtilsSocket.checkMessageEnd(new StringBuffer(wrong1)));
		assertFalse(UtilsSocket.checkMessageEnd(new StringBuffer(wrong2)));
	}

	@Test
	public void testWriteToFile() {
		try {
			byte[] testInput = ConstantsTestSocketUtils.expectedByteValue;
			UtilsSocket.writeToFile(testInput, ConstantsTestSocketUtils.filePathWriteTestFile);
			byte[] readBack = UtilsSocket.readFileToBytes(ConstantsTestSocketUtils.filePathWriteTestFile);
			assertTrue(Arrays.equals(testInput, readBack));
			// delete the file again
			File file = new File(ConstantsTestSocketUtils.filePathWriteTestFile);
			file.delete();
		} catch (IOException ioExc) {
			fail("IOExcepation when testing writing to file.");
		}
	}

	@Test
	public void testGetJsonPayload() {
		String input = "myJsonPayload";
		String result = UtilsSocket
				.getJsonPayload(new StringBuffer(input + ConstantsNetwork.MESSAGE_TERMINATION_STRING));
		assertEquals(result, input);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetJsonPayloadExc() {
		String input = "myJsonPayload";
		UtilsSocket.getJsonPayload(new StringBuffer(input));
	}

	@Test
	public void getSocketHostRemoteExecution() {
		try {
			String remoteHost = "remoteHost";
			assertEquals(remoteHost, UtilsSocket.getSocketHost(remoteHost, false));
		} catch (UnknownHostException uhExc) {
			fail("unknown host exception");
		}
	}
}
