package me.arya.webapp.integrationtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "feature/bookSearch.integrationtest")
public class BookSearchIT {

}
