package at.uibk.dps;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * This class is used to handle socket utils.
 *
 * @author stefanpedratscher
 */
public class SocketUtils {

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
        sendJsonString(destinationSocket, new Gson().toJson(jsonObject));
    }

    /**
     * Sends the given generic Json Object to the given socket.
     *
     * @param destinationSocket to send string to.
     * @param jsonObject        to convert to string and send to socket.
     * @throws IOException on failure.
     */
    public static<T> void sendJsonObject(Socket destinationSocket, T jsonObject) throws IOException {
        sendJsonString(destinationSocket, new Gson().toJson(jsonObject));
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
        return getJsonPayload(buffer);
    }

    /**
     * Receives and returns a json object from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the json object.
     * @throws IOException on failure.
     */
    public static JsonObject receiveJsonObject(Socket sourceSocket) throws IOException {
        return new Gson().fromJson(receiveJsonString(sourceSocket), JsonObject.class);
    }

    /**
     * Receives and returns a generic json object from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the generic json object.
     * @throws IOException on failure.
     */
    public static <T> T receiveJsonObject(Socket sourceSocket, Class<T> objectClass) throws IOException {
        return new Gson().fromJson(receiveJsonString(sourceSocket), objectClass);
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
