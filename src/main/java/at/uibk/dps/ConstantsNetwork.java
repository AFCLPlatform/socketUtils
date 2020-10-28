package at.uibk.dps;

/**
 * Constants defined within the network.
 */
public class ConstantsNetwork {

    /**
     * Default constructor.
     */
    private ConstantsNetwork() { }

    /**
     * Request type.
     */
    public enum RequestType {
        ATTRIBUTE_EXEC_TIME
    }

    // module address information

    // enactment engine
    public static final String EE_HOST = "ee-service"
    public static final int EE_PORT = 9000;

    // scheduler
    public static final String SCHEDULER_HOST = "scheduler";
    public static final int SCHEDULER_PORT = 9002;

    // resource selector
    public static final String SELECTOR_HOST = "selector-service";
    public static final int SELECTOR_PORT = 9003;

    // attribute service
    public static final String ATTRIBUTE_SERVICE_HOST = "predictor";
    public static final int ATTRIBUTE_SERVICE_PORT = 9006;

    // logger service
    public static final String LOGGER_SERVICE_HOST = "logger-service";
    public static final int LOGGER_SERVICE_PORT = 9005;

    // message protocol information

    // termination string
    public static final String MESSAGE_TERMINATION_STRING = "\\0";


    // JSON message strings

    // response of the attribute service
    public static final String JSON_RESPONSE_ATTR_KEY = "queried attribute";

}
