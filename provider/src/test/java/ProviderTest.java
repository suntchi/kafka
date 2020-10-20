import com.stc.kafka.StcKafkaProviderApplication;
import com.stc.kafka.provider.HelloKafka;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = StcKafkaProviderApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ProviderTest {

    @Resource(name = "helloKafka")
    private HelloKafka helloKafka;
    @Test
    public void test(){

        helloKafka.sendHelloKafka();
    }
}

