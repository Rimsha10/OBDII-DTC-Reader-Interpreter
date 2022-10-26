package com.example.mydtcreader.response;

public interface Response {
    /**
     * The list of byte receive after sending the command
     *
     * @return The raw command result
     */
    byte[] getRawResult();

    /**
     * The string representation of the command result
     *
     * @return The formatted result
     */
    String getFormattedString();

    /**
     * @return The unit of the command result
     */

}
