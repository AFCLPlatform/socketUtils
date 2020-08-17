package at.uibk.dps;

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
     * Sends the given Json String to the given socket.
     *
     * @param destinationSocket to send string to.
     * @param jsonString to send.
     * @throws IOException on failure.
     */
    public static void sendJsonString(Socket destinationSocket, String jsonString) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(destinationSocket.getOutputStream(), StandardCharsets.UTF_8);
        osw.write(jsonString, 0, jsonString.length());
        osw.flush();
    }

    /**
     * Receives and returns a json string from the given socket.
     *
     * @param sourceSocket the socket to listen to.
     * @return the json string.
     * @throws IOException on failure.
     *
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
     * Returns {@code true} iff the given buffer ends with the string defined as the
     * termination string of messages.
     *
     * @param buffer the message buffer.
     * @return {@code true} iff the given buffer ends with the string defined as the
     *         termination string of messages.
     */
    private static boolean checkMessageEnd(StringBuffer buffer) {
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
    private static String getJsonPayload(StringBuffer msg) {
        int endLength = ConstantsNetwork.MESSAGE_TERMINATION_STRING.length();
        return msg.substring(0, msg.length() - endLength);
    }
}
