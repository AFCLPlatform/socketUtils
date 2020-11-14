package at.uibk.dps.communication;

import java.io.IOException;

import at.uibk.dps.SocketUtils;

/**
 * This class is used to define the request which will be sent from
 * the scheduler or AFCLPortal to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public class EnactmentEngineRequestUtils {

	/**
	 * Method used as static method container
	 */
	private EnactmentEngineRequestUtils() {
	}
	
	/**
	 * Returns an enactment engine request by workflow file content.
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(final byte[] fileContent, final boolean logResults) {
		return new EnactmentEngineRequest(fileContent, logResults);
	}

	/**
	 * Returns an enactment engine request by workflow file content and workflow
	 * input file.
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFileContent(final byte[] fileContent, final byte[] inputContent, final boolean logResults) {
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
	public static EnactmentEngineRequest getEnactmentEngineRequestFilePath(final String filePath, final byte[] inputContent, final boolean logResults)
			throws IOException {
		byte[] workFlowData = SocketUtils.readFileToBytes(filePath);
		if (inputContent == null) {
			return getEnactmentEngineRequestFileContent(workFlowData, logResults);
		} else {
			return getEnactmentEngineRequestFileContent(workFlowData, inputContent, logResults);
		}
	}

	/**
	 * See method above. Used in cases without the wokflow content.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static EnactmentEngineRequest getEnactmentEngineRequestFilePath(final String filePath, final boolean logResults) throws IOException {
		return getEnactmentEngineRequestFilePath(filePath, null, logResults);
	}
}
