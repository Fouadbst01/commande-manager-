package org.sid.orderservicequery;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceQueryApplication.class, args);
    }

    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[] { "org.sid.**" });
        return xStream;
    }

}
