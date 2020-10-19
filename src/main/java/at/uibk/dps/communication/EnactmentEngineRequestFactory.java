package at.uibk.dps.communication;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class is used to define the request which will be sent from
 * the scheduler or AFCLPortal to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequestFactory {

	/**
	 * Returns an enactment engine request by workflow file content.
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(byte[] fileContent, boolean logResults) {
		return new EnactmentEngineRequest(fileContent, logResults);
	}

	/**
	 * Returns an enactment engine request by workflow file content and workflow
	 * input file.
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(byte[] fileContent, byte[] inputContent, boolean logResults) {
		return new EnactmentEngineRequest(fileContent, inputContent, logResults);
	}

	/**
	 * Returns an {@link EnactmentEngineRequest} created from the workflow saved in
	 * the file with the provided path.
	 * 
	 * @param filePath     the provided path name
	 * @param inputContent the content of the workflow input (can be null)
	 * @return the {@link EnactmentEngineRequest} containing the wf as specified in
	 *         the provided file.
	 * @throws IOException
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFilePath(String filePath, byte[] inputContent, boolean logResults)
			throws IOException {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(data, 0, data.length);
		bis.close();
		if (inputContent == null) {
			return getEnactmentEngineRequestFileContent(data, logResults);
		} else {
			return getEnactmentEngineRequestFileContent(data, inputContent, logResults);
		}
	}

	/**
	 * See method above. Used in cases without the wokflow content.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFilePath(String filePath, boolean logResults) throws IOException {
		return getEnactmentEngineRequestFilePath(filePath, null, logResults);
	}
}
