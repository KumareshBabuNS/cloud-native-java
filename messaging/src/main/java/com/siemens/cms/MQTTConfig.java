package com.siemens.cms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.ManagementContext;
import org.apache.activemq.hooks.SpringContextHook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siemens.cms.brokerplugins.TokenAuthenticationPlugin;

@Configuration
public class MQTTConfig {

	@Bean(initMethod = "start", destroyMethod = "stop")
    public BrokerService broker() throws Exception {
        final BrokerService broker = new BrokerService();
        //enableAuthPlugin(broker);

        broker.addConnector("mqtt://localhost:1883");
        broker.addConnector("ws://localhost:1884");
        broker.setPersistent(false);
        broker.setShutdownHooks(Collections.<Runnable>singletonList(new SpringContextHook()));
        final ManagementContext managementContext = new ManagementContext();
        managementContext.setCreateConnector(true);
        broker.setManagementContext(managementContext);

        return broker;
    }

    private void enableAuthPlugin(BrokerService broker) {
        TokenAuthenticationPlugin authPlugin = new TokenAuthenticationPlugin();
        BrokerPlugin[] existPlugins = broker.getPlugins();
        if (existPlugins == null) existPlugins = new BrokerPlugin[] {};
        ArrayList<BrokerPlugin> newPlugins = new ArrayList<BrokerPlugin>();
        newPlugins.addAll(Arrays.asList(existPlugins));
        newPlugins.add(authPlugin);
        // Setup the broker
        broker.setPlugins(newPlugins.toArray(existPlugins));
    }
}
