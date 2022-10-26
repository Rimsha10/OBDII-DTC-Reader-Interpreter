package com.example.mydtcreader.response;

import com.example.mydtcreader.TroubleCode;

import java.io.IOException;

/**
 *
 * @author MacFJA
 */
public class DiagnosticTroubleCodeResponse extends RawResponse {
    public DiagnosticTroubleCodeResponse(byte[] rawResult) {
        super(rawResult);
    }

    public TroubleCode getTroubleCode() {
        //createFromHex --method of TroubleCode, takes hex as args
        return TroubleCode.createFromHex(new String(getRawResult()));
    }

    @Override
    public String getFormattedString() {
        TroubleCode tc = getTroubleCode();
        String description;
        String decodecode= tc.getDetail().toString();
        //System.out.println(decodecode);
        //System.out.println(getTroubleCode().toString()=="P1107");
        String input=tc.toString();
        try {
            description = " " + tc.getDescription(tc.toString());
            //System.out.println(tc.getDescription(input));

        } catch (IOException e) {
            description = "";
        }
        return tc.toString() + "\nTrouble causing Part: " +tc.getType() +"\nGenre: " +decodecode + "\nDescription: "+ description;
    }
}
