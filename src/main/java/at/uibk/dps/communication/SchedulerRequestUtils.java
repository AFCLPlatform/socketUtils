package at.uibk.dps.communication;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is used to define the request which will be sent from the
 * AFCLPortal to the scheduler module.
 *
 * @author stefanpedratscher
 */
public class SchedulerRequestUtils {

	/**
	 * Default constructor.
	 */
	private SchedulerRequestUtils() {
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow the file describing the WF to orchestrate
	 * @return the orchestration request sent to the scheduler
	 */
	public static SchedulerRequest getSchedulerRequestFileContent(final byte[] workflow) {
		return new SchedulerRequest(workflow);
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow        the file describing the WF to orchestrate
	 * @param input           the file with the workflow input
	 * @param schedulerConfig the file with the scheduler configuration
	 * @return the orchestration request sent to the scheduler
	 */
	public static SchedulerRequest getSchedulerRequestFileContent(final byte[] workFlow, final byte[] input,
			final byte[] schedulerConfig) {
		return new SchedulerRequest(workFlow, input, schedulerConfig);
	}

	/**
	 * Returns an orchestration request to the scheduler
	 * 
	 * @param workflow        the file describing the WF to orchestrate
	 * @param schedulerConfig the file with the scheduler configuration
	 * @return the orchestration request sent to the scheduler
	 */
	public static SchedulerRequest getSchedulerRequestFileContent(final byte[] workflow, final byte[] schedulerConfig) {
		final SchedulerRequest schedulerRequest = new SchedulerRequest(workflow);
		schedulerRequest.setSchedulerConfig(schedulerConfig);
		return schedulerRequest;
	}

	/**
	 * Returns an {@link SchedulerRequest} created from the workflow saved in the
	 * file with the provided path.
	 * 
	 * @param filePath the provided path name
	 * @return the {@link SchedulerRequest} containing the wf as specified in the
	 *         provided file.
	 * @throws IOException
	 */
	public static SchedulerRequest getSchedulerRequestFilePath(final String filePath) throws IOException {
		final File file = new File(filePath);
		final byte[] data = new byte[(int) file.length()];
		try (InputStream fis = Files.newInputStream(Paths.get(filePath))) {
			try (BufferedInputStream bis = new BufferedInputStream(fis)) {
				bis.read(data, 0, data.length);
			}
		}
		return getSchedulerRequestFileContent(data);
	}
}
