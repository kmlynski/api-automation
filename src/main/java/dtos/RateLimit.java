package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimit {

    private int coreLimit;
    private int searchLimit;
    private int graphqlLimit;
    private int graphqlRemaining;
    private int searchRemaining;

    @SuppressWarnings("unchecked")
    @JsonProperty("resources")
    private void unmarshallNested(Map<String,Object> resources){
        Map<String, Integer> core = (Map<String, Integer>) resources.get("core");
        coreLimit = core.get("limit");

        Map<String, Integer > search = (Map<String, Integer>) resources.get("search");
        searchLimit = search.get("limit");
        searchRemaining = search.get("remaining");

        Map<String, Integer> graphql = (Map<String, Integer>) resources.get("graphql");
        graphqlLimit = graphql.get("limit");
        graphqlRemaining = graphql.get("remaining");

    }

    public int getCoreLimit() {
        return coreLimit;
    }

    public int getSearchLimit() {
        return searchLimit;
    }

    public int getGraphqlRemaining() {
        return graphqlRemaining;
    }

    public int getGraphqlLimit() {
        return graphqlLimit;
    }

    public int getSearchRemaining() {
        return searchRemaining;
    }
}
