package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    @Component
    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("setNoBean1 = " + noBean1);

        }
        @Autowired(required = false)
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("setNoBean2 = " + noBean2);

        }
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("setNoBean3 = " + noBean3);

        }

    }
}
