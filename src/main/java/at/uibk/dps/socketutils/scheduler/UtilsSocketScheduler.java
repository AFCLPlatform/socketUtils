package at.uibk.dps.socketutils.scheduler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonObject;

import at.uibk.dps.socketutils.entity.Statistics;

/**
 * This class is used to define the request which will be sent from the
 * AFCLPortal to the scheduler module.
 *
 * @author stefanpedratscher
 */
public final class UtilsSocketScheduler {

	/**
	 * Default constructor.
	 */
	private UtilsSocketScheduler() {
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow the file describing the WF to orchestrate
	 * @return the orchestration request sent to the scheduler
	 */
	public static RequestScheduler generateRequest(final byte[] workflow) {
		return new RequestScheduler(workflow);
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow        the file describing the WF to orchestrate
	 * @param input           the file with the workflow input
	 * @param schedulerConfig the file with the scheduler configuration
	 * @return the orchestration request sent to the scheduler
	 */
	public static RequestScheduler generateRequest(final byte[] workFlow, final byte[] input,
			final byte[] schedulerConfig) {
		return new RequestScheduler(workFlow, input, schedulerConfig);
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow        the file describing the WF to orchestrate
	 * @param schedulerConfig the file with the scheduler configuration
	 * @return the orchestration request sent to the scheduler
	 */
	public static RequestScheduler generateRequest(final byte[] workflow, final byte[] schedulerConfig) {
		return new RequestScheduler(workflow, null, schedulerConfig);
	}

	/**
	 * Returns an {@link RequestScheduler} created from the workflow saved in the
	 * file with the provided path.
	 * 
	 * @param filePath the provided path name
	 * @return the {@link RequestScheduler} containing the wf as specified in the
	 *         provided file.
	 * @throws IOException
	 */
	public static RequestScheduler generateRequest(final String filePath) throws IOException {
		final File file = new File(filePath);
		final byte[] data = new byte[(int) file.length()];
		try (InputStream fis = Files.newInputStream(Paths.get(filePath))) {
			try (BufferedInputStream bis = new BufferedInputStream(fis)) {
				bis.read(data, 0, data.length);
			}
		}
		return generateRequest(data);
	}

	/**
	 * Generates a scheduler response with the provided content.
	 * 
	 * @param workflowResult            Json object with the calculation result
	 * @param executionId               the execution ID of the workflow
	 * @param enactmentEngineStatistics the statistics describing the EE
	 * @param schedulerStatistics       the statistics describing the scheduler
	 * @return a scheduler response with the provided content
	 */
	public static ResponseScheduler generateResponse(final JsonObject workflowResult, final int executionId,
			final Statistics enactmentEngineStatistics, final Statistics schedulerStatistics) {
		return new ResponseScheduler(workflowResult, executionId, enactmentEngineStatistics, schedulerStatistics);
	}
}
