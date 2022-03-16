package com.example.loginandsignuppae.Registration;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //TODO: use regex to validate
        return true;
    }
}
