package at.uibk.dps.socketutils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * This class is used to handle socket utils.
 *
 * @author stefanpedratscher
 */
public final class UtilsSocket {

	private final static Logger LOGGER = Logger.getLogger(UtilsSocket.class.getName());

	/**
	 * Default constructor.
	 */
	private UtilsSocket() {
	}

	/**
	 * Method to enable a local, non-module based execution of the scheduler.
	 * 
	 * @param remoteHost     the string of the host, if executed as a module
	 * @param localExecution {@code true} iff local execution
	 * @return the host string to use
	 */
	public static String getSocketHost(final String remoteHost, final boolean localExecution)
			throws UnknownHostException {
		return localExecution ? InetAddress.getLocalHost().getHostName() : remoteHost;
	}

	/**
	 * Sends the given Json String to the given socket.
	 *
	 * @param outputStream the output stream to send to
	 * @param jsonString   to send.
	 * @throws IOException on failure.
	 */
	public static void sendJsonString(final OutputStream outputStream, final String jsonString) throws IOException {
		LOGGER.info(new Supplier<String>() {
			@Override
			public String get() {
				return "Sending " + jsonString + ConstantsNetwork.MESSAGE_TERMINATION_STRING;
			}
		});
		final OutputStreamWriter osw = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		osw.write(jsonString + ConstantsNetwork.MESSAGE_TERMINATION_STRING, 0,
				jsonString.length() + ConstantsNetwork.MESSAGE_TERMINATION_STRING.length());
		osw.flush();
	}

	/**
	 * Sends the given Json Object to the given socket.
	 *
	 * @param outputStream the output stream to send to
	 * @param jsonObject   to convert to string and send to socket.
	 * @throws IOException on failure.
	 */
	public static void sendJsonObject(final OutputStream outputStream, final JsonObject jsonObject) throws IOException {
		sendJsonString(outputStream,
				new GsonBuilder().setDateFormat(ConstantsNetwork.DATE_FORMAT).create().toJson(jsonObject));
	}

	/**
	 * Sends the given generic Json Object to the given socket.
	 *
	 * @param outputStream the output stream to send to
	 * @param jsonObject   to convert to string and send to socket.
	 * @throws IOException on failure.
	 */
	public static <T> void sendJsonObject(final OutputStream outputStream, final T jsonObject) throws IOException {
		sendJsonString(outputStream,
				new GsonBuilder().setDateFormat(ConstantsNetwork.DATE_FORMAT).create().toJson(jsonObject));
	}

	/**
	 * Sends the give byte[] to the given socket.
	 *
	 * @param outputStream the output stream to send to
	 * @param bytes        to send.
	 * @throws IOException on failure.
	 */
	public static void sendBytes(final OutputStream outputStream, final byte[] bytes) throws IOException {
		LOGGER.info("Sending byte[]");
		final OutputStream out = outputStream;
		out.write(bytes);
		out.flush();
	}

	/**
	 * Receives and returns a json string from the given socket.
	 *
	 * @param inputStream the input stream.
	 * @return the json string.
	 * @throws IOException on failure.
	 */
	public static String receiveJsonString(final InputStream inputStream) throws IOException {
		final InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		int data = reader.read();
		final StringBuffer buffer = new StringBuffer();
		while (data != -1) {
			final char character = (char) data;
			buffer.append(character);
			if (checkMessageEnd(buffer)) {
				break;
			}
			data = reader.read();
		}
		final String result = getJsonPayload(buffer);
		LOGGER.info(() -> "Received " + result);
		return result;
	}

	/**
	 * Receives and returns a json object from the given socket.
	 *
	 * @param inputStream the input stream to listen to
	 * @return the json object.
	 * @throws IOException on failure.
	 */
	public static JsonObject receiveJsonObject(final InputStream inputStream) throws IOException {
		return new GsonBuilder().setDateFormat(ConstantsNetwork.DATE_FORMAT).create()
				.fromJson(receiveJsonString(inputStream), JsonObject.class);
	}

	/**
	 * Receives and returns a generic json object from the given socket.
	 *
	 * @param inputStream the input stream to listen to
	 * @return the generic json object.
	 * @throws IOException on failure.
	 */
	public static <T> T receiveJsonObject(final InputStream inputStream, final Class<T> objectClass)
			throws IOException {
		return new GsonBuilder().setDateFormat(ConstantsNetwork.DATE_FORMAT).create()
				.fromJson(receiveJsonString(inputStream), objectClass);
	}

	/**
	 * Receives and stores a byte[] to a file.
	 *
	 * @param inputStream the input stream to listen to
	 * @param fileName    the name and path of the file.
	 * @throws IOException on failure.
	 */
	public static void receiveBytesAndWriteToFile(final InputStream inputStream, final String fileName)
			throws IOException {
		try (OutputStream out = Files.newOutputStream(Paths.get(fileName))) {
			/* Read bytes and write to output stream */
			final byte[] bytes = new byte[16 * 1024];
			assert inputStream != null;
			int count = inputStream.read(bytes);
			while (count >= 0) {
				out.write(bytes, 0, count);
				if (inputStream.available() == 0) {
					break;
				}
				count = inputStream.read(bytes);
			}
			out.flush();
		}
	}

	/**
	 * Write byte[] to file.
	 *
	 * @param bytes    content to write to file.
	 * @param fileName the name and path of the file.
	 * @throws IOException on failure.
	 */
	public static void writeToFile(final byte[] bytes, final String fileName) throws IOException {
		try (OutputStream out = Files.newOutputStream(Paths.get(fileName))) {
			out.write(bytes, 0, bytes.length);
			out.flush();
		}
	}

	/**
	 * Reads a file at the specified path and converts it to an array of bytes.
	 * 
	 * @param filePath the path to the file
	 * @return the byte array
	 * @throws IOException
	 */
	public static byte[] readFileToBytes(final String filePath) throws IOException {
		final File file = new File(filePath);
		final byte[] result = new byte[(int) file.length()];
		try (InputStream fis = Files.newInputStream(Paths.get(filePath))) {
			try (BufferedInputStream bis = new BufferedInputStream(fis)) {
				bis.read(result, 0, result.length);
			}
		}
		return result;
	}

	/**
	 * Returns {@code true} iff the given buffer ends with the string defined as the
	 * termination string of messages.
	 *
	 * @param buffer the message buffer.
	 * @return {@code true} iff the given buffer ends with the string defined as the
	 *         termination string of messages.
	 */
	private static boolean checkMessageEnd(final StringBuffer buffer) {
		final int start = buffer.length() - ConstantsNetwork.MESSAGE_TERMINATION_STRING.length();
		if (start < 0) {
			return false;
		} else {
			return ConstantsNetwork.MESSAGE_TERMINATION_STRING.equals(buffer.substring(start));
		}
	}

	/**
	 * Generates the json payload by cutting of the end string.
	 *
	 * @param msg the raw message.
	 * @return the message payload.
	 */
	private static String getJsonPayload(final StringBuffer msg) {
		final int endLength = ConstantsNetwork.MESSAGE_TERMINATION_STRING.length();
		return msg.substring(0, msg.length() - endLength);
	}
}
