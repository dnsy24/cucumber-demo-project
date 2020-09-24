package com.company.services.attachments.implementations;

import io.cucumber.java.Scenario;

@FunctionalInterface
public interface Attachments {

    void attachScreenShotIfFailed(Scenario scenario);
}
