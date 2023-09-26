package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatusServiceTest {
    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatusService statusService1 = ac.getBean(StatusService.class);
        StatusService statusService2 = ac.getBean(StatusService.class);

        statusService1.order("userA", 10000);
        statusService2.order("userB", 20000);

        int price = statusService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statusService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatusService statefulService(){
            return new StatusService();

        }
    }

}