package org.egov.transformer.models.downstream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.egov.common.models.household.Household;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseholdIndexV1 {
    @JsonProperty("household")
    private Household household;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("nameOfUser")
    private String nameOfUser;
    @JsonProperty("role")
    private String role;
    @JsonProperty("boundaryHierarchy")
    private ObjectNode boundaryHierarchy;
    @JsonProperty("geoPoint")
    private List<Double> geoPoint;
}