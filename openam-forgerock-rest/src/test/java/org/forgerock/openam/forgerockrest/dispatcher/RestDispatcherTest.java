/**
 *
 ~ DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 ~
 ~ Copyright (c) 2011-2013 ForgeRock AS. All Rights Reserved
 ~
 ~ The contents of this file are subject to the terms
 ~ of the Common Development and Distribution License
 ~ (the License). You may not use this file except in
 ~ compliance with the License.
 ~
 ~ You can obtain a copy of the License at
 ~ http://forgerock.org/license/CDDLv1.0.html
 ~ See the License for the specific language governing
 ~ permission and limitations under the License.
 ~
 ~ When distributing Covered Code, include this CDDL
 ~ Header Notice in each file and include the License file
 ~ at http://forgerock.org/license/CDDLv1.0.html
 ~ If applicable, add the following below the CDDL Header,
 ~ with the fields enclosed by brackets [] replaced by
 ~ your own identifying information:
 ~ "Portions Copyrighted [year] [name of copyright owner]"
 *
 */
package org.forgerock.openam.forgerockrest.dispatcher;

import com.iplanet.sso.SSOToken;
import com.sun.identity.sm.OrganizationConfigManager;
import com.sun.identity.sm.SMSException;
import org.forgerock.openam.forgerockrest.RestDispatcher;
import org.junit.runner.RunWith;
import org.mortbay.jetty.testing.ServletTester;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testng.annotations.Test;


/**
 * Forgerock-Rest Test Suite
 *
 * @author alin.brici@forgerock.com
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(RestDispatcher.class)
@SuppressStaticInitializationFor("com.sun.identity.sm.OrganizationConfigManager")

// Alin: extending something in order to test it makes me very nervious, as it implies the code is
// poorly structured (protected methods and hidden detail) and not compatible with being unit tested.
class OrgnazationConfigManagerTest extends OrganizationConfigManager{
    public OrgnazationConfigManagerTest(SSOToken token, String realm) throws SMSException {
        super(token, realm);
    }
}

public class RestDispatcherTest {
    private static ServletTester servletTester;

    private final static String resourceName = "/realm/subrealm/users/demo";

    @Test
    public void testGetRequestDetails() {
        //TODO Mock OrganizationConfigManger
        /*suppress(constructor(OrganizationConfigManager.class));
        Map<String, String> details = new HashMap<String, String>(3);
        Map<String, String> parsedDetails = new HashMap<String, String>(3);
        try {

            details.put("realmPath", "/realm/subrealm");
            details.put("resourceName", "/users");
            details.put("resourceId", "demo");
            OrganizationConfigManager ocm = Whitebox.newInstance(OrgnazationConfigManagerTest.class);
            whenNew(OrganizationConfigManager.class).withArguments(any(SSOToken.class), anyString()).thenReturn(ocm);
            RestDispatcher rD = RestDispatcher.getInstance();
            parsedDetails = Whitebox.invokeMethod(RestDispatcher.class, "getRequestDetails", resourceName);

            assertTrue(parsedDetails.equals(details));

        } catch (IOException ioe) {

        } catch (Exception e) {

        } */
    }
}
