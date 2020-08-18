package at.uibk.dps.communication.entity;

/**
 * Contains several details for a function.
 *
 * @author stefanpedratscher
 */
public class FunctionDetails {

    /**
     * Programming language in which the function is written.
     */
    private String language;

    /**
     * Resource link of the function.
     */
    private String functionLink;

    /**
     * If there are any free invocations.
     */
    private boolean freeInvocations;

    /**
     * Default constructor for function details.
     *
     * @param language programming language of the function.
     * @param functionLink resource link of the function.
     * @param freeInvocations if there are free invocations.
     */
    public FunctionDetails(String language, String functionLink, boolean freeInvocations) {
        this.language = language;
        this.functionLink = functionLink;
        this.freeInvocations = freeInvocations;
    }

    /** Getter and Setter */

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFunctionLink() {
        return functionLink;
    }

    public void setFunctionLink(String functionLink) {
        this.functionLink = functionLink;
    }

    public boolean isFreeInvocations() {
        return freeInvocations;
    }

    public void setFreeInvocations(boolean freeInvocations) {
        this.freeInvocations = freeInvocations;
    }
}