package io.harness.ff.examples;

import io.harness.cf.client.api.*;
import io.harness.cf.client.dto.Target;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GettingStarted {
    // API Key - set this as an env variable
    private static String apiKey = "87829453-3bc6-4ffb-bf81-94a0f6bfc9f0";

    // Flag Identifier
    private static String flagIdentifier = "demoflag";

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        System.out.println("Harness SDK Getting Started");

        try {
            //Create a Feature Flag Client
            CfClient cfClient = new CfClient(apiKey);
            cfClient.waitForInitialization();

            // Create a target (different targets can get different results based on rules.  This includes a custom attribute 'location')
            final Target target = Target.builder()
                    .identifier("javasdk")
                    .name("JavaSDK")
                    .attribute("location", "emea")
                    .build();

            // Loop forever reporting the state of the flag
            scheduler.scheduleAtFixedRate(
                    () -> {
                        boolean result = cfClient.boolVariation(flagIdentifier, target, false);
                        System.out.println("Boolean variation is " + result);
                    },
                    0,
                    10,
                    TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the SDK
            CfClient.getInstance().close();
        }
    }
}
