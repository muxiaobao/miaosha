package com.miaoshaproject.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * spring-configuration-metadata.json中没有的属性，可以定制化内嵌Tomcat的方式修改
 *
 * 当spring容器内没有TomcatEmbeddedServletContainerFactory这个bean时，会将该bean注入spring容器中
 *
 * spring启动后，会将application.properties文件中关于内嵌tomcat的参数加载到这里的protocol内，
 * 此处定义的WebServerConfiguration类会将前面的参数传到ConfigurableWebServerFactory，在该factory内可以定制化
 * 某些参数
 *
 */

@Component
public class WebServerConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {


    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        // 定制化tomcat connector

        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();

                // 定制化keepalivetimeout，设置30s内没有请求，则服务端自动断开keepalive连接
                protocol.setKeepAliveTimeout(30000);
                // 当客户端发送超过10000个请求则自动断开keepalive连接
                protocol.setMaxKeepAliveRequests(10000);

                // 此处也可以设置max-connections, accept count等参数

            }
        });
    }
}
