package org.egov.project.validator.facility;

import lombok.extern.slf4j.Slf4j;
import org.egov.common.models.Error;
import org.egov.common.validator.Validator;
import org.egov.project.repository.ProjectRepository;
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
import static org.egov.common.utils.ValidatorUtils.getErrorForNonExistentRelatedEntity;
import static org.egov.project.Constants.GET_PROJECT_ID;

@Component
@Order(value = 6)
@Slf4j
public class PfProjectIdValidator implements Validator<ProjectFacilityBulkRequest, ProjectFacility> {

    private final ProjectRepository projectRepository;

    @Autowired
    public PfProjectIdValidator(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Map<ProjectFacility, List<Error>> validate(ProjectFacilityBulkRequest request) {
        log.info("validating project id");
        Map<ProjectFacility, List<Error>> errorDetailsMap = new HashMap<>();
        List<ProjectFacility> entities = request.getProjectFacilities();
        Class<?> objClass = getObjClass(entities);
        Method idMethod = getMethod(GET_PROJECT_ID, objClass);
        Map<String, ProjectFacility> eMap = getIdToObjMap(entities
                .stream().filter(notHavingErrors()).collect(Collectors.toList()), idMethod);
        if (!eMap.isEmpty()) {
            List<String> entityIds = new ArrayList<>(eMap.keySet());
            List<String> existingProjectIds = projectRepository.validateIds(entityIds,
                    getIdFieldName(idMethod));
            List<ProjectFacility> invalidEntities = entities.stream().filter(notHavingErrors()).filter(entity ->
                    !existingProjectIds.contains(entity.getProjectId()))
                            .collect(Collectors.toList());
            invalidEntities.forEach(projectFacility -> {
                Error error = getErrorForNonExistentRelatedEntity(projectFacility.getProjectId());
                populateErrorDetails(projectFacility, error, errorDetailsMap);
            });
        }

        return errorDetailsMap;
    }
}
