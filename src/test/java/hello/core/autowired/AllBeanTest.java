package hello.core.autowired;

import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        new AnnotationConfigApplicationContext();

    }

    static class DisCountService{
        private final Map<String, DiscountPolicy> policyMap;

        DisCountService(Map<String, DiscountPolicy> policyMap) {
            this.policyMap = policyMap;
        }
    }
}
