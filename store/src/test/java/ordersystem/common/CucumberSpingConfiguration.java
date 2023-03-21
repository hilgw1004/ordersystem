package ordersystem.common;

import io.cucumber.spring.CucumberContextConfiguration;
import ordersystem.StoreApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreApplication.class })
public class CucumberSpingConfiguration {}
