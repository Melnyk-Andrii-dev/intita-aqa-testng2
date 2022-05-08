package org.intita.enums.userAttrubutes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserPassword {
    CMANAGER_PASSWORD("qaintita");
    private final String value;

    public String toString() {
        return value;
    }
}
