package com.example.mydtcreader.command;

import com.example.mydtcreader.response.Response;

import java.io.IOException;
import java.io.InputStream;

public interface Command {
    /**
     * The hex string of the command
     *
     * @return The command
     */
    String getRequest();

    /**
     * Get the {@link Response} of the command create from the command {@code rawResult}
     *
     * @param rawResult The response of OBD for the command
     * @return The response object
     */
    Response getResponse(byte[] rawResult);


    String readRawData(InputStream in) throws IOException;
    //throws ScriptException;


}
