/*eGov  SmartCity eGovernance suite aims to improve the internal efficiency,transparency,
accountability and the service delivery of the government  organizations.

 Copyright (C) <2017>  eGovernments Foundation

 The updated version of eGov suite of products as by eGovernments Foundation
 is available at http://www.egovernments.org

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see http://www.gnu.org/licenses/ or
 http://www.gnu.org/licenses/gpl.html .

 In addition to the terms of the GPL license to be adhered to in using this
 program, the following additional terms are to be complied with:

     1) All versions of this program, verbatim or modified must carry this
        Legal Notice.
    Further, all user interfaces, including but not limited to citizen facing interfaces, 
        Urban Local Bodies interfaces, dashboards, mobile applications, of the program and any 
        derived works should carry eGovernments Foundation logo on the top right corner.

    For the logo, please refer http://egovernments.org/html/logo/egov_logo.png.
    For any further queries on attribution, including queries on brand guidelines, 
        please contact contact@egovernments.org

     2) Any misrepresentation of the origin of the material is prohibited. It
        is required that all modified versions of this material be marked in
        reasonable ways as different from the original version.

     3) This license does not grant any rights to any user of the program
        with regards to rights under trademark law for use of the trade names
        or trademarks of eGovernments Foundation.
*/

package org.egov.mrs.domain.service;

import java.util.HashMap;
import java.util.Map;

import org.egov.mrs.application.MarriageConstants;
import org.egov.mrs.domain.entity.MarriageRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarriageRegistrationThirdPartyService {

    private final MarriageRegistrationService marriageRegistrationService;

    @Autowired
    public MarriageRegistrationThirdPartyService(final MarriageRegistrationService marriageRegistrationService) {
        this.marriageRegistrationService = marriageRegistrationService;
    }

    public Map<String, String> validateMarriageRegistration(final String applicationNo) {
        final MarriageRegistration marriageRegsitration = marriageRegistrationService.findByApplicationNo(applicationNo);
        final Map<String, String> statusCommentsMap = new HashMap<String, String>();
        if (marriageRegsitration.getStatus().getCode().equals(MarriageConstants.CREATED)
                || marriageRegsitration.getStatus().getCode().equals(MarriageConstants.APPROVED)
                || marriageRegsitration.getStatus().getCode()
                        .equals(MarriageConstants.DIGITALSIGNED)) {
            statusCommentsMap.put("status", MarriageConstants.OPEN);
            statusCommentsMap.put("comments", marriageRegsitration.getState().getComments());
            statusCommentsMap.put("updatedBy", marriageRegsitration.getState().getLastModifiedBy().getName());
        } else if (marriageRegsitration.getStatus().getCode().equals(MarriageConstants.REGISTERED)) {
            statusCommentsMap.put("status", MarriageConstants.APPROVED);
            statusCommentsMap.put("comments", marriageRegsitration.getState().getComments());
            statusCommentsMap.put("updatedBy", marriageRegsitration.getState().getLastModifiedBy().getName());
        } else if (marriageRegsitration.getStatus().getCode().equals(MarriageConstants.CANCELLED)) {
            statusCommentsMap.put("status", MarriageConstants.REJECTED);
            statusCommentsMap.put("comments", marriageRegsitration.getState().getComments());
            statusCommentsMap.put("updatedBy", marriageRegsitration.getState().getLastModifiedBy().getName());
        }
        return statusCommentsMap;
    }

}
