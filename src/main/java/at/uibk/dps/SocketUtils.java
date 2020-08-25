package at.uibk.dps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/**
 * This class is used to handle socket utils.
 *
 * @author stefanpedratscher
 */
public class SocketUtils {

    private final static Logger LOGGER = Logger.getLogger(SocketUtils.class.getName());

    /**
     * Default constructor.
     */
    private SocketUtils() {
    }

    /**
     * Sends the given Json String to the given socket.
     *
     * @param destinationSocket to send string to.
     * @param jsonString        to send.
     * @throws IOException on failure.
     */
    public static void sendJsonString(Socket destinationSocket, String jsonString) throws IOException {
        LOGGER.info("Sending " + jsonString + ConstantsNetwork.MESSAGE_TERMINATION_STRING);
        OutputStreamWriter osw = new OutputStreamWriter(destinationSocket.getOutputStream(), StandardCharsets.UTF_8);
        osw.write(jsonString + ConstantsNetwork.MESSAGE_TERMINATION_STRING, 0, jsonString.length() + ConstantsNetwork.MESSAGE_TERMINATION_STRING.length());
        osw.flush();
    }

    /**
     * Sends the given Json Object to the given socket.
     *
     * @param destinationSocket to send string to.
     * @param jsonObject        to convert to string and send to socket.
     * @throws IOException on failure.
     */
    public static void sendJsonObject(Socket destinationSocket, JsonObject jsonObject) throws IOException {
        sendJsonString(destinationSocket, new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .create()
                .toJson(jsonObject));
    }

    /**
     * Sends the given generic Json Object to the given socket.
     *
     * @param destinationSocket to send string to.
     * @param jsonObject        to convert to string and send to socket.
     * @throws IOException on failure.
     */
    public static <T> void sendJsonObject(Socket destinationSocket, T jsonObject) throws IOException {
        sendJsonString(destinationSocket, new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .create()
                .toJson(jsonObject));
    }

    /**
     * Sends the give byte[] to the given socket.
     *
     * @param destinationSocket to send byte[] to.
     * @param bytes             to send.
     * @throws IOException on failure.
     */
    public static void sendBytes(Socket destinationSocket, byte[] bytes) throws IOException {
        LOGGER.info("Sending byte[]");
        OutputStream out = destinationSocket.getOutputStream();
        out.write(bytes);
        out.flush();
    }

    /**
     * Receives and returns a json string from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the json string.
     * @throws IOException on failure.
     */
    public static String receiveJsonString(Socket sourceSocket) throws IOException {
        InputStreamReader reader = new InputStreamReader(sourceSocket.getInputStream(), StandardCharsets.UTF_8);
        int data = reader.read();
        StringBuffer buffer = new StringBuffer();
        while (data != -1) {
            char c = (char) data;
            buffer.append(c);
            if (checkMessageEnd(buffer)) {
                break;
            }
            data = reader.read();
        }
        String result = getJsonPayload(buffer);
        LOGGER.info("Received " + result);
        return result;
    }

    /**
     * Receives and returns a json object from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the json object.
     * @throws IOException on failure.
     */
    public static JsonObject receiveJsonObject(Socket sourceSocket) throws IOException {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .create()
                .fromJson(receiveJsonString(sourceSocket), JsonObject.class);
    }

    /**
     * Receives and returns a generic json object from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the generic json object.
     * @throws IOException on failure.
     */
    public static <T> T receiveJsonObject(Socket sourceSocket, Class<T> objectClass) throws IOException {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .create()
                .fromJson(receiveJsonString(sourceSocket), objectClass);
    }

    /**
     * Receives and stores a byte[] to a file.
     *
     * @param sourceSocket the socket to listen to.
     * @param fileName     the name and path of the file.
     * @throws IOException on failure.
     */
    public static void receiveBytesAndWriteToFile(Socket sourceSocket, String fileName) throws IOException {

        OutputStream out = new FileOutputStream(fileName);

        /* Get input and output stream */
        InputStream in = sourceSocket.getInputStream();

        /* Read bytes and write to output stream */
        byte[] bytes = new byte[16 * 1024];
        int count;
        assert in != null;
        while ((count = in.read(bytes)) >= 0) {
            out.write(bytes, 0, count);
            if (in.available() == 0) {
                break;
            }
        }
        out.flush();
    }

    /**
     * Write byte[] to file.
     *
     * @param bytes content to write to file.
     * @param fileName     the name and path of the file.
     * @throws IOException on failure.
     */
    public static void writeToFile(byte[] bytes, String fileName) throws IOException {
        OutputStream out = new FileOutputStream(fileName);
        out.write(bytes, 0, bytes.length);
        out.flush();
    }

    /**
     * Returns {@code true} iff the given buffer ends with the string defined as the
     * termination string of messages.
     *
     * @param buffer the message buffer.
     * @return {@code true} iff the given buffer ends with the string defined as the
     * termination string of messages.
     */
    protected static boolean checkMessageEnd(StringBuffer buffer) {
        int start = buffer.length() - ConstantsNetwork.MESSAGE_TERMINATION_STRING.length();
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
    protected static String getJsonPayload(StringBuffer msg) {
        int endLength = ConstantsNetwork.MESSAGE_TERMINATION_STRING.length();
        return msg.substring(0, msg.length() - endLength);
    }
}
