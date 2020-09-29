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
public class SchedulerRequestFactory {

    /**
     * Returns an scheduler request by workflow file content.
     */
    public static SchedulerRequest getSchedulerRequestFileContent(byte[] fileContent) {
        return new SchedulerRequest(fileContent);
    }

    /**
     * Returns an scheduler request by workflow file content and workflow input file.
     */
    public static SchedulerRequest getSchedulerRequestFileContent(byte[] fileContent, byte[] inputContent, byte[] schedulerConfigContent) {
        return new SchedulerRequest(fileContent, inputContent, schedulerConfigContent);
    }

    /**
     * Returns an scheduler request by workflow file content and workflow input file.
     */
    public static SchedulerRequest getSchedulerRequestFileContent(byte[] fileContent, byte[] schedulerConfigContent) {
        SchedulerRequest schedulerRequest = new SchedulerRequest(fileContent);
        schedulerRequest.setSchedulerConfigContent(schedulerConfigContent);
        return schedulerRequest;
    }
    
    /**
     * Returns an {@link SchedulerRequest} created from the workflow saved in the file with the provided path.
     * 
     * @param filePath the provided path name
     * @return the {@link SchedulerRequest} containing the wf as specified in the provided file.
     * @throws IOException 
     */
    public static SchedulerRequest getSchedulerRequestFilePath(String filePath) throws IOException {
    	File file = new File(filePath);
    	FileInputStream fis = new FileInputStream(file);
    	byte[] data = new byte[(int) file.length()];
    	BufferedInputStream bis = new BufferedInputStream(fis);
    	bis.read(data, 0, data.length);
    	bis.close();
    	return getSchedulerRequestFileContent(data);
    }
}
