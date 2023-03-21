package ordersystem.common;

import io.cucumber.spring.CucumberContextConfiguration;
import ordersystem.CustomerApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerApplication.class })
public class CucumberSpingConfiguration {}
