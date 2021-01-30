package com.miraclekang.clouddemo.identity.test;

import com.miraclekang.clouddemo.identity.application.TenantManagementService;
import com.miraclekang.clouddemo.identity.application.command.ActivateTenantCommand;
import com.miraclekang.clouddemo.identity.application.service.TenantServiceImpl;
import com.miraclekang.clouddemo.identity.domain.model.identity.Tenant;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class TenantServiceTest {

    public static int a = 1;

    @Before
    public void resetXxx() {
        a = 1;
    }

    @Test
    public void testActivateTenant() {

        TenantManagementService tenantManagementService = new TenantServiceImpl() {

            @Override
            protected Tenant existingTenant(String aTenantId) {
                return new Tenant();
            }
        };

        tenantManagementService.activateTenant("abc",
                new ActivateTenantCommand(LocalDateTime.now().plusMonths(1L)));

        if (a == 1) {
            a = 2;
        }
        assert a == 2;
    }

    @Test
    public void testXxx() {
        a = 3;
    }
}
