package at.uibk.dps.communication;


/**
 * This class is used to define the request which will be sent
 * to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequestFactory {

    /**
     * Return a selector request for free function resources.
     */
    public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(byte[] fileContent) {
        return new EnactmentEngineRequest(fileContent);
    }
}
