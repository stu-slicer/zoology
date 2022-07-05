package com.nology.zoology.animal;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AnimalBeforeEachCallback implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.printf("Running: %s\n", extensionContext.getDisplayName());
        System.out.printf("Instance: %s\n", extensionContext.getTestInstance());
        System.out.printf("Class: %s\n", extensionContext.getTestClass());
        System.out.printf("Method: %s\n", extensionContext.getTestMethod().get().getName() );
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.printf("After: %s\n", context.getDisplayName());
        System.out.printf("Result: %s\n", context.getExecutionMode());

    }
}
