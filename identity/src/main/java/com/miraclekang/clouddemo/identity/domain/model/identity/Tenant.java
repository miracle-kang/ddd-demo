package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.identity.domain.model.access.TenantLicenseService;
import com.miraclekang.clouddemo.infrastructure.domain.EntityBase;
import com.miraclekang.clouddemo.infrastructure.domain.model.Enablement;
import com.miraclekang.clouddemo.infrastructure.utils.IdentifyUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tenant extends EntityBase {

    private TenantId tenantId;
    private String name;
    private String description;

    public Tenant(TenantId tenantId, String name, String description) {
        Validate.notNull(tenantId, "The tenantId is required.");
        Validate.notBlank(name, "The tenant name is required.");

        this.tenantId = tenantId;
        this.name = name;
        this.description = description;
    }

    /**
     * Change tenant info
     *
     * @param name        new tenant name
     * @param description new tenant description
     */
    public void changeInfo(String name, String description) {
        Validate.notBlank(name, "The tenant name is required.");

        this.name = name;
        this.description = description;
    }

    /**
     * Register a new user.
     *
     * @param username             user's username (account)
     * @param password             user's password
     * @param enablement           enablement info
     * @param person               user personal info
     * @param tenantLicenseService license domain service
     * @return a new user
     */
    public User registerUser(String username, String password, Enablement enablement, Person person,
                             TenantLicenseService tenantLicenseService) {

        // Check tenant license if available
        if (tenantLicenseService != null) {
            Validate.isTrue(tenantLicenseService.isTenantLicense(tenantId), "Tenant license expired.");
        }

        User user = new User(
                this.tenantId,
                new UserId(IdentifyUtils.nextSnowflakeId()),
                username,
                password,
                enablement,
                person
        );

        this.registerEvent(new UserRegistered(
                this.tenantId,
                user.getUserId(),
                user.getUsername(),
                user.getEnablement(),
                user.getPerson().getName(),
                user.getPerson().getContact().getEmail()
        ));
        return user;
    }

}
