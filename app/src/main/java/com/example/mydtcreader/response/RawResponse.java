package com.example.mydtcreader.response;

public class RawResponse implements Response {

    /* Base (abstract) class for a {@link Response} of a {@link io.github.macfja.obd2.Command}
     *
     * @author MacFJA
     */
    private byte[] rawResult;

    public RawResponse(byte[] rawResult) {
        this.rawResult = rawResult;
    }

    @Override
    public byte[] getRawResult() {
        return rawResult;
    }

    @Override
    public String getFormattedString() {
        return new String(rawResult);
    }

    /*@Override
    public Unit getUnit() {
        return Unit.NoUnit;
    }*/
}