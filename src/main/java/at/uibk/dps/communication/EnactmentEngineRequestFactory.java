package at.uibk.dps.communication;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class is used to define the request which will be sent
 * to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequestFactory {

    /**
     * Returns an enactment engine request by workflow file content.
     */
    public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(byte[] fileContent) {
        return new EnactmentEngineRequest(fileContent);
    }

    /**
     * Returns an enactment engine request by workflow file content and workflow input file.
     */
    public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(byte[] fileContent, byte[] inputContent) {
        return new EnactmentEngineRequest(fileContent, inputContent);
    }
    
    /**
     * Returns an {@link EnactmentEngineRequest} created from the workflow saved in the file with the provided path.
     * 
     * @param filePath the provided path name
     * @return the {@link EnactmentEngineRequest} containing the wf as specified in the provided file.
     * @throws IOException 
     */
    public static EnactmentEngineRequest getEnactmentEngineRequestFilePath(String filePath) throws IOException {
    	File file = new File(filePath);
    	FileInputStream fis = new FileInputStream(file);
    	byte[] data = new byte[(int) file.length()];
    	BufferedInputStream bis = new BufferedInputStream(fis);
    	bis.read(data, 0, data.length);
    	bis.close();
    	return getEnactmentEngineRequestFileContent(data);
    }
}
