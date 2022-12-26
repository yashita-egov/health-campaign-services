package org.egov.helper;

import org.egov.common.helper.RequestInfoTestBuilder;
import org.egov.web.models.ApiOperation;
import org.egov.web.models.HouseholdRequest;

import java.util.Arrays;

public class HouseholdRequestTestBuilder {
    private HouseholdRequest.HouseholdRequestBuilder builder;

    public HouseholdRequestTestBuilder() {
        this.builder = HouseholdRequest.builder();
    }

    public static HouseholdRequestTestBuilder builder() {
        return new HouseholdRequestTestBuilder();
    }

    public HouseholdRequest build() {
        return this.builder.build();
    }

    public HouseholdRequestTestBuilder withHousehold(){
        this.builder.household(Arrays.asList(HouseholdTestBuilder.builder().withHousehold().build()));
        return this;
    }

    public HouseholdRequestTestBuilder withRequestInfo(){
        this.builder.requestInfo(RequestInfoTestBuilder.builder().withCompleteRequestInfo().build());
        return this;
    }

    public HouseholdRequestTestBuilder withApiOperationCreate(){
     this.builder.apiOperation(ApiOperation.CREATE);
     return this;
    }

    public HouseholdRequestTestBuilder withApiOperationDelete(){
        this.builder.apiOperation(ApiOperation.DELETE);
        return this;
    }

    public HouseholdRequestTestBuilder withApiOperationUpdate(){
        this.builder.apiOperation(ApiOperation.UPDATE);
        return this;
    }
}
