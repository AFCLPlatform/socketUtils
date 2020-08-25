package at.uibk.dps.communication;

import java.math.BigDecimal;

/**
 * This class is used to define the response from
 * the mapping annotator module.
 *
 * @author stefanpedratscher
 */
public class AnnotatorResponse {

    /**
     * Average execution time of the given function.
     */
    private BigDecimal avgExecutionTime;

    /** Constructors */

    public AnnotatorResponse(BigDecimal avgExecutionTime) {
        this.avgExecutionTime = avgExecutionTime;
    }

    /** Getter and Setter */

    public BigDecimal getAvgExecutionTime() {
        return avgExecutionTime;
    }

    public void setAvgExecutionTime(BigDecimal avgExecutionTime) {
        this.avgExecutionTime = avgExecutionTime;
    }
}
