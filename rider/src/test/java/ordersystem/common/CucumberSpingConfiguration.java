package ordersystem.common;

import io.cucumber.spring.CucumberContextConfiguration;
import ordersystem.RiderApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RiderApplication.class })
public class CucumberSpingConfiguration {}
