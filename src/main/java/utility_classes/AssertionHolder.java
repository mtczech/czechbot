package utility_classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is purely a data class for getting the assertion from the JSON file
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssertionHolder {
    public AssertionHolder() {

    }

    private String assertion;

    public void setAssertion(String setAssertion) {
        assertion = setAssertion;
    }

    public String getAssertion() {
        return assertion;
    }
}
