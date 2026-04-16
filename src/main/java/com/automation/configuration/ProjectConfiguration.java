package com.automation.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.automation"})
@PropertySource("classpath:data/test-data.properties")
public class ProjectConfiguration {

    @Value("${browser.name}")
    private String browserName;

    @Bean
    public WebDriverProvider webDriverProvider() {
        return new WebDriverProvider() {
            private WebDriver driver;

            @Override
            public WebDriver get() {
                if (driver == null) {
                    switch (Browsers.of(browserName)) {
                        case CHROME:
                            WebDriverManager.chromedriver().setup();

                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments("--start-maximized");
                            chromeOptions.addArguments("--window-size=1920,1080");
                            chromeOptions.addArguments("--force-device-scale-factor=1");
                            chromeOptions.addArguments("--disable-notifications");
                            chromeOptions.addArguments("--disable-infobars");
                            chromeOptions.addArguments("--remote-allow-origins=*");

                            driver = new ChromeDriver(chromeOptions);

                            try {
                                driver.manage().window().maximize();
                            } catch (Exception e) {
                                System.out.println("Could not maximize Chrome window: " + e.getMessage());
                            }

                            try {
                                driver.manage().window().setSize(new Dimension(1920, 1080));
                            } catch (Exception e) {
                                System.out.println("Could not set Chrome window size: " + e.getMessage());
                            }

                            System.out.println("Chrome window size after setup: " + driver.manage().window().getSize());
                            break;

                        case FIREFOX:
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver();

                            try {
                                driver.manage().window().maximize();
                            } catch (Exception e) {
                                System.out.println("Could not maximize Firefox window: " + e.getMessage());
                            }

                            try {
                                driver.manage().window().setSize(new Dimension(1920, 1080));
                            } catch (Exception e) {
                                System.out.println("Could not set Firefox window size: " + e.getMessage());
                            }

                            System.out.println("Firefox window size after setup: " + driver.manage().window().getSize());
                            break;

                        case IE:
                            WebDriverManager.iedriver().setup();
                            driver = new InternetExplorerDriver();

                            try {
                                driver.manage().window().maximize();
                            } catch (Exception e) {
                                System.out.println("Could not maximize IE window: " + e.getMessage());
                            }

                            try {
                                driver.manage().window().setSize(new Dimension(1920, 1080));
                            } catch (Exception e) {
                                System.out.println("Could not set IE window size: " + e.getMessage());
                            }

                            System.out.println("IE window size after setup: " + driver.manage().window().getSize());
                            break;

                        default:
                            throw new IllegalArgumentException("Invalid browser name: " + browserName);
                    }
                }
                return driver;
            }

            @Override
            public void initialize() {
                get();
            }

            @Override
            public boolean saveScreenshotTo(String path) {
                return false;
            }

            @Override
            public void end() {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }
        };
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriverScreenshotOnFailure screenshotOnFailureDriver() {
        return new WebDriverScreenshotOnFailure(webDriverProvider());
    }
}