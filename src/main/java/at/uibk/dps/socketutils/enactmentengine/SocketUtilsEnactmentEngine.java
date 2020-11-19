package at.uibk.dps.socketutils.enactmentengine;

import java.io.IOException;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.SocketUtils;
import at.uibk.dps.socketutils.entity.Statistics;

/**
 * This class is used to define the request which will be sent from the
 * scheduler or AFCLPortal to the enactment engine module.
 *
 * @author stefanpedratscher
 */
public final class SocketUtilsEnactmentEngine {

	/**
	 * Method used as static method container
	 */
	private SocketUtilsEnactmentEngine() {
	}

	/**
	 * Returns an enactment engine request by workflow file content.
	 */
	public static RequestEnactmentEngine generateRequest(final byte[] fileContent, final boolean logResults) {
		return new RequestEnactmentEngine(fileContent, logResults);
	}

	/**
	 * Returns an enactment engine request by workflow file content and workflow
	 * input file.
	 */
	public static RequestEnactmentEngine generateRequest(final byte[] fileContent, final byte[] inputContent,
			final boolean logResults) {
		return new RequestEnactmentEngine(fileContent, inputContent, logResults);
	}

	/**
	 * Returns an {@link RequestEnactmentEngine} created from the workflow saved in
	 * the file with the provided path.
	 * 
	 * @param filePath     the provided path name
	 * @param inputContent the content of the workflow input (can be null)
	 * @return the {@link RequestEnactmentEngine} containing the wf as specified in
	 *         the provided file.
	 * @throws IOException
	 */
	public static RequestEnactmentEngine generateRequest(final String filePath, final byte[] inputContent,
			final boolean logResults) throws IOException {
		final byte[] workFlowData = SocketUtils.readFileToBytes(filePath);
		if (inputContent == null) {
			return generateRequest(workFlowData, logResults);
		} else {
			return generateRequest(workFlowData, inputContent, logResults);
		}
	}

	/**
	 * See method above. Used in cases without the workflow content.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static RequestEnactmentEngine generateRequest(final String filePath, final boolean logResults)
			throws IOException {
		return generateRequest(filePath, null, logResults);
	}

	/**
	 * Generates the EE response with the details about the WF execution.
	 * 
	 * @param workflowResult            the result of the calculation
	 * @param executionId               the execution ID
	 * @param enactmentEngineStatistics the statistics describing the run
	 * @return the EE response with the details about the WF execution
	 */
	public static ResponseEnactmentEngine generateResponse(final JsonObject workflowResult, final int executionId,
			final Statistics enactmentEngineStatistics) {
		return new ResponseEnactmentEngine(workflowResult, executionId, enactmentEngineStatistics);
	}
}
