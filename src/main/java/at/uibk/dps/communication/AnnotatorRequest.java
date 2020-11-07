package at.uibk.dps.communication;

/**
 * This class is used to define the request which will be sent
 * from the scheduler to the mapping annotator module.
 *
 * @author stefanpedratscher
 */
public class AnnotatorRequest {

    /**
     * Type of the request.
     */
    private AnnotatorRequestType requestType;

    /**
     * The resource link of the cloud function.
     */
    private String functionLink;
    
    /**
     * Contains all possible types for a
     * annotator request.
     */
    public enum AnnotatorRequestType {
        GET_AVG_EXEC_TIME
    }
    

    /** Constructors */

    public AnnotatorRequest(AnnotatorRequestType requestType, String functionLink) {
        this.requestType = requestType;
        this.functionLink = functionLink;
    }

    /** Getter and Setter */

    public AnnotatorRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(AnnotatorRequestType requestType) {
        this.requestType = requestType;
    }

    public String getFunctionLink() {
        return functionLink;
    }

    public void setFunctionLink(String functionLink) {
        this.functionLink = functionLink;
    }
}
