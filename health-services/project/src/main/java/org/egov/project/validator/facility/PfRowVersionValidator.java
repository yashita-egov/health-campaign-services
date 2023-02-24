package org.egov.project.validator.facility;

import lombok.extern.slf4j.Slf4j;
import org.egov.common.models.Error;
import org.egov.common.validator.Validator;
import org.egov.project.repository.ProjectFacilityRepository;
import org.egov.project.web.models.ProjectFacility;
import org.egov.project.web.models.ProjectFacilityBulkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.egov.common.utils.CommonUtils.*;
import static org.egov.common.utils.ValidatorUtils.getErrorForRowVersionMismatch;

@Component
@Order(value = 5)
@Slf4j
public class PfRowVersionValidator implements Validator<ProjectFacilityBulkRequest, ProjectFacility> {

    private final ProjectFacilityRepository repository;

    @Autowired
    public PfRowVersionValidator(ProjectFacilityRepository repository) {
        this.repository = repository;
    }


    @Override
    public Map<ProjectFacility, List<Error>> validate(ProjectFacilityBulkRequest request) {
        log.info("validating row version");
        Map<ProjectFacility, List<Error>> errorDetailsMap = new HashMap<>();
        Method idMethod = getIdMethod(request.getProjectFacilities());
        Map<String, ProjectFacility> eMap = getIdToObjMap(request.getProjectFacilities().stream()
                .filter(notHavingErrors())
                .collect(Collectors.toList()), idMethod);
        if (!eMap.isEmpty()) {
            List<String> entityIds = new ArrayList<>(eMap.keySet());
            List<ProjectFacility> existingEntities = repository.findById(entityIds, false,
                    getIdFieldName(idMethod));
            List<ProjectFacility> entitiesWithMismatchedRowVersion =
                    getEntitiesWithMismatchedRowVersion(eMap, existingEntities, idMethod);
            entitiesWithMismatchedRowVersion.forEach(projectFacility -> {
                Error error = getErrorForRowVersionMismatch();
                populateErrorDetails(projectFacility, error, errorDetailsMap);
            });
        }
        return errorDetailsMap;
    }
}
