/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.carbon.identity.outbound.provisioning.connector.office365;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;

public class Office365ProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory {

    private static final Log log = LogFactory.getLog(Office365ProvisioningConnectorFactory.class);
    private static final String CONNECTOR_TYPE = "Office365";

    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(
            Property[] provisioningProperties) throws IdentityProvisioningException {
        Office365ProvisioningConnector connector = new Office365ProvisioningConnector();
        connector.init(provisioningProperties);
        if (log.isDebugEnabled()) {
            log.debug("Office365 provisioning connector created successfully.");
        }
        return connector;
    }

    @Override
    public String getConnectorType() {
        return CONNECTOR_TYPE;
    }

    @Override
    public List<Property> getConfigurationProperties() {
        List<Property> properties = new ArrayList<>();

        Property clientId = new Property();
        clientId.setName(Office365ConnectorConstants.OFFICE365_CLIENT_ID);
        clientId.setDisplayName("Client ID");
        clientId.setDisplayOrder(1);
        clientId.setRequired(true);

        Property clientSecret = new Property();
        clientSecret.setName(Office365ConnectorConstants.OFFICE365_CLIENT_SECRET);
        clientSecret.setDisplayName("Client Secret");
        clientSecret.setConfidential(true);
        clientSecret.setDisplayOrder(2);
        clientSecret.setRequired(true);

        Property tenant = new Property();
        tenant.setName(Office365ConnectorConstants.OFFICE365_TENANT);
        tenant.setDisplayName("Office365 Tenant Name");
        tenant.setDescription("Example : username.onmicrosoft.com");
        tenant.setDisplayOrder(3);
        tenant.setRequired(true);

        Property domain = new Property();
        domain.setName(Office365ConnectorConstants.OFFICE365_DOMAIN);
        domain.setDisplayName("Office365 Domain Name");
        domain.setDisplayOrder(4);
        domain.setRequired(true);

        Property immutableId = new Property();
        immutableId.setName(Office365ConnectorConstants.OFFICE365_IMMUTABLE_ID);
        immutableId.setDisplayName("Immutable ID");
        immutableId.setDisplayOrder(5);
        immutableId.setRequired(true);

        Property domainEnabled = new Property();
        domainEnabled.setName(Office365ConnectorConstants.OFFICE365_ENABLE_DOMAIN);
        domainEnabled.setDisplayName("Enable Domain Name in UPN");
        domainEnabled.setDescription("If enabled domain name will be appended to UPN");
        domainEnabled.setDisplayOrder(6);

        Property upn = new Property();
        upn.setName(Office365ConnectorConstants.OFFICE365_UPN);
        upn.setDisplayName("User Principal Name");
        upn.setDisplayOrder(7);
        upn.setRequired(true);

        Property displayName = new Property();
        displayName.setName(Office365ConnectorConstants.OFFICE365_DISPLAY_NAME);
        displayName.setDisplayName("Display Name");
        displayName.setDisplayOrder(8);
        displayName.setRequired(true);

        Property mailNickName = new Property();
        mailNickName.setName(Office365ConnectorConstants.OFFICE365_EMAIL_NICKNAME);
        mailNickName.setDisplayName("Email Nickname");
        mailNickName.setDisplayOrder(9);
        mailNickName.setRequired(true);

        properties.add(clientId);
        properties.add(clientSecret);
        properties.add(tenant);
        properties.add(domain);
        properties.add(immutableId);
        properties.add(domainEnabled);
        properties.add(upn);
        properties.add(displayName);
        properties.add(mailNickName);

        return properties;
    }

}
