package org.egov.transformer.models.downstream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.egov.common.models.individual.Name;
import org.egov.transformer.models.attendance.AttendanceRegister;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendanceRegisterIndexV1 {
    @JsonProperty("attendanceRegister")
    private AttendanceRegister attendanceRegister;
    @JsonProperty("attendeesInfo")
    private Map<String, Name> attendeesInfo;
    @JsonProperty("transformerTimeStamp")
    private String transformerTimeStamp;
}