package com.example.mydtcreader.command;

import com.example.mydtcreader.response.DiagnosticTroubleCodeResponse;
import com.example.mydtcreader.response.Response;
import com.github.pires.obd.exceptions.NonNumericResponseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DTCsCommand implements Command {
    protected String rawData=null;
    protected ArrayList<Integer> buffer = null;


    @Override
    public String getRequest() {
        return "03";
    }


    @Override
    public Response getResponse(final byte[] rawResult) //throws ScriptException
    {
        return new DiagnosticTroubleCodeResponse(rawResult);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String readRawData(InputStream in) throws IOException {
        byte b = 0;
        StringBuilder res = new StringBuilder();
        // read until '>' arrives OR end of stream reached
        char c;
        // -1 if the end of the stream is reached
        while (((b = (byte) in.read()) > -1)) {
            c = (char) b;
            if (c == '>') // read until '>' arrives
            {
                break;
            }
            res.append(c);
        }
        /*
         * Imagine the following response 41 0c 00 0d.
         *
         * ELM sends strings!! So, ELM puts spaces between each "byte". And pay
         * attention to the fact that I've put the word byte in quotes, because 41
         * is actually TWO bytes (two chars) in the socket. So, we must do some more
         * processing..
         */
        rawData = res.toString().replaceAll("SEARCHING", "");

        /*
         * Data may have echo or informative text like "INIT BUS..." or similar.
         * The response ends with two carriage return characters. So we need to take
         * everything from the last carriage return before those two (trimmed above).
         */
        //kills multiline.. rawData = rawData.substring(rawData.lastIndexOf(13) + 1);
        rawData = rawData.replaceAll("\\s", "");//removes all [ \t\n\x0B\f\r]
        return rawData;
    }
    public void sendCommand(OutputStream outputStream,String command) throws IOException {
        outputStream.write(command.getBytes());
        outputStream.flush();
    }
}
