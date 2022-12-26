package org.sid.orderservicecommand;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceCommandApplication.class, args);
    }
    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[] { "org.sid.**" });
        return xStream;
    }

}
