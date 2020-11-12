package com.ebill.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/ebill/features/",
glue= {"src/test/java/com/ebill/bdd"},plugin = {"pretty"})

public class CucumberRunner_EbillCalculator {
}
