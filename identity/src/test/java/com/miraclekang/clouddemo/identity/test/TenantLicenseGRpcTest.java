package com.miraclekang.clouddemo.identity.test;

import com.miraclekang.clouddemo.identity.IdentityApplication;
import com.miraclekang.clouddemo.identity.domain.model.identity.TenantId;
import com.miraclekang.clouddemo.identity.port.adapter.service.access.TenantLicenseGRpcClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2020/5/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {IdentityApplication.class})
public class TenantLicenseGRpcTest {

    @Autowired
    private TenantLicenseGRpcClient gRpcClient;

    @Test
    public void loadContext() {
        Assert.assertTrue(gRpcClient.isTenantLicense(new TenantId("test")));
        System.out.println("Test complete.");
    }
}
