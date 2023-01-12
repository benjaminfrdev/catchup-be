package com.project.be.api.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class Validation {

    public boolean checkValidUUID(String uuid) {
        Pattern UUID_REGEX =
                Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        return UUID_REGEX.matcher(uuid).matches();

    }

}
