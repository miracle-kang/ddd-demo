package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.identity.domain.model.access.RoleId;
import com.miraclekang.clouddemo.identity.domain.model.access.TenantRoleService;
import com.miraclekang.clouddemo.identity.domain.repository.TenantRepository;
import com.miraclekang.clouddemo.identity.domain.repository.UserRepository;
import com.miraclekang.clouddemo.infrastructure.domain.DomainEventPublisher;
import com.miraclekang.clouddemo.infrastructure.domain.model.Enablement;
import com.miraclekang.clouddemo.infrastructure.utils.IdentifyUtils;
import org.springframework.stereotype.Service;

@Service
public class TenantProvisioningService {

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final TenantRoleService tenantRoleService;

    public TenantProvisioningService(UserRepository userRepository,
                                     TenantRepository tenantRepository,
                                     TenantRoleService tenantRoleService) {
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.tenantRoleService = tenantRoleService;
    }

    public Tenant provisionTenant(String tenantName,
                                  String tenantDescription,
                                  FullName administratorName,
                                  EmailAddress emailAddress,
                                  Telephone telephone) {

        Tenant tenant = new Tenant(
                new TenantId(IdentifyUtils.nextSnowflakeId()),
                tenantName,
                tenantDescription
        );
        tenantRepository.save(tenant);

        // publish tenant provisioned event.
        DomainEventPublisher.instance()
                .publish(new TenantProvisioned(tenant.getTenantId()));


        User tenantAdmin = tenant.registerUser(
                "admin",
                "Administrator",
                Enablement.indefinite(),
                new Person(
                        tenant.getTenantId(),
                        administratorName,
                        new ContactInformation(
                                emailAddress,
                                telephone
                        )
                ),
                null
        );
        userRepository.save(tenantAdmin);

        // publish tenant administrator registered event
        DomainEventPublisher.instance().publish(new TenantAdministratorRegistered(
                tenant.getTenantId(),
                tenantName,
                tenantAdmin.getUserId(),
                tenantAdmin.getUsername(),
                administratorName,
                emailAddress
        ));

        // provision admin role and assign to user.
        RoleId adminRole = tenantRoleService.provisionRole(tenant.getTenantId(),
                "Administrator",
                "Tenant " + tenantName + " only Administrator role.");
        tenantRoleService.assignUserToRole(tenantAdmin.getUserId(), adminRole);
        return tenant;
    }
}
