package com.miraclekang.clouddemo.identity.port.adapter.restful;

import com.miraclekang.clouddemo.identity.application.TenantManagementService;
import com.miraclekang.clouddemo.identity.application.command.ActivateTenantCommand;
import com.miraclekang.clouddemo.identity.application.command.ChangeTenantInfoCommand;
import com.miraclekang.clouddemo.identity.application.command.ProvisionTenantCommand;
import com.miraclekang.clouddemo.identity.application.dto.TenantDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/identity/tenants")
@Api(tags = "Tenant Management API")
public class TenantManagementController {

    private final TenantManagementService tenantManagementService;

    public TenantManagementController(TenantManagementService tenantManagementService) {
        this.tenantManagementService = tenantManagementService;
    }

    @PostMapping("/")
    @ApiOperation("Provision a new tenant")
    public TenantDto newTenant(@RequestBody ProvisionTenantCommand command) {
        return tenantManagementService.provisionTenant(command);
    }

    @PutMapping("/{tenantId}")
    @ApiOperation("Change tenant info")
    public TenantDto changeTenantInfo(@PathVariable String tenantId,
                                      @RequestBody ChangeTenantInfoCommand command) {
        return tenantManagementService.changeTenantInfo(tenantId, command);
    }

    @GetMapping("/{tenantId}")
    @ApiOperation("Get tenant info")
    public TenantDto getTenant(@PathVariable String tenantId) {
        return tenantManagementService.tenant(tenantId);
    }

    @PostMapping("/{tenantId}/activate")
    @ApiOperation("Activate tenant")
    public void activateTenant(@PathVariable String tenantId,
                               @RequestBody ActivateTenantCommand command) {
        tenantManagementService.activateTenant(tenantId, command);
    }

    @PostMapping("/{tenantId}/deactivate")
    @ApiOperation("Deactivate tenant")
    public void deactivateTenant(@PathVariable String tenantId) {
        tenantManagementService.deactivateTenant(tenantId);
    }
}
