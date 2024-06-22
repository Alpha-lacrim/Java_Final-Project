package org.example.myfinalproject;

public enum Status {
    NO_PAY_DISMISSAL("No Pay Dismissal"),
    FIRED("Fired"),
    RETIRED("Retired"),
    END_OF_CONTRACT("End Of Contract"),
    HAS_CHANGED("Has Changed");

    private final String status;

    private Status(String str) {
        status = str;
    }

    public String toString() {
        return this.status;
    }
}
