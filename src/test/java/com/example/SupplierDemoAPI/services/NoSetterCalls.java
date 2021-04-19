package com.example.SupplierDemoAPI.services;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoSetterCalls implements VerificationMode {

    private final Pattern regexPattern;

    public NoSetterCalls() {
        this.regexPattern = Pattern.compile("set[A-Z].*");
    }

    @Override
    public void verify(VerificationData verificationData) {

        List<Invocation> invocations = verificationData.getAllInvocations();
        for (Invocation invocation :
                invocations) {
            Matcher matcher = this.regexPattern.matcher(invocation.getMethod().getName());
            if (matcher.matches()) {
                throw Reporter.wantedButNotInvoked(invocation, invocations);
            }
        }
    }
}
