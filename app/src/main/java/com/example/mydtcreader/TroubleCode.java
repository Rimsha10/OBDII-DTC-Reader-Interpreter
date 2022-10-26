package com.example.mydtcreader;


import com.example.mydtcreader.enums.Description;
import com.example.mydtcreader.enums.Detail;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Object representation of a Diagnostic Trouble Code (DTC)
 *
 * @author MacFJA
 */

public class TroubleCode {
    public static final String UNKNOWN_TROUBLE_CODE = "Unknown DTC";
    private final Type type;
    private final Domain domain;
    private final String code;
    //private final Detail dcode;

    public TroubleCode(Type type, Domain domain, String code) {
        this.type = type;
        this.domain = domain;
        this.code = code;
      //  this.dcode = dcode;
    }

    public static TroubleCode createFromString(String line) {
        Type type = Type.getType(Character.valueOf(line.charAt(0)));
        Domain domain = Domain.getDomain(Integer.parseInt(String.valueOf(line.charAt(1))));
        //Detail dcode= Detail.getDetail(Integer.parseInt(String.valueOf(line.charAt(2))));
        String code = line.substring(2);

        return new TroubleCode(type, domain, code);
    }

    public static TroubleCode createFromHex(String hex) {
        // A DTC is contains in 4 hex chars
        String corrected = hex.substring(0, 4);
        return createFromBin(String.format("%16s", new BigInteger(corrected, 16).toString(2)).replace(' ', '0'));
    }

    public static TroubleCode createFromBin(String bin) {
        Type type = Type.getType(Integer.parseInt(bin.substring(0, 2), 2));
        Domain domain = Domain.getDomain(Integer.parseInt(bin.substring(2, 4), 2));
        //Detail dcode = Detail.getDetail(Integer.parseInt(bin.substring(4, 6), 2));
        String code = Integer.toHexString(Integer.parseInt(bin.substring(4, 16), 2));
        return new TroubleCode(type, domain, code);
    }

    public Type getType() {
        return type;
    }

    public Domain getDomain() {
        return domain;
    }

    public String getDescription(String line) throws IOException {
        System.out.println(line);
        System.out.println(Description.getDescription(line));
        return Description.getDescription(line);
    }

    public Detail getDetail(){
        String dcode_no=code.substring(0,1);
        return Detail.getDetail(Integer.parseInt(dcode_no));

    }

    @Override
    public String toString() {
        return type.letter.toString() + Integer.toString(domain.code) + code;
    }

    public boolean isValid() {
        return type != null && domain != null;
    }






    /**
     * The type of the Trouble Code (The first letter of the DTC)
     *
     * @author MacFJA
     */
    public enum Type {
        Powertrain('P', 0),
        Body('B', 2),
        Chassis('C', 1),
        UserNetwork('U', 3);

        private final Character letter;
        private final int code;

        Type(Character letter, int code) {
            this.letter = letter;
            this.code = code;
        }

        /**
         * Get the Trouble Code Type from its letter.
         *
         * @param letter The type letter to search
         * @return The type, or {@code null} if the letter doesn't exist as a Type
         */
        public static Type getType(Character letter) {
            for (Type type : values()) {
                if (type.letter.equals(letter)) {
                    return type;
                }
            }
            return null;
        }

        /**
         * Get the Trouble Code Type from its code.
         *
         * @param code The type code to search
         * @return The type
         * @throws IndexOutOfBoundsException If {@code code} is less than 0 or more than 3 (code is a 2 bits value)
         */
        public static Type getType(int code) {
            if (code < 0 || code > 3) {
                throw new IndexOutOfBoundsException(
                        "Type code is a 2 bits value, therefor can only vary between 0 and 3 (both included)"
                );
            }

            for (Type type : values()) {
                if (type.code == code) {
                    return type;
                }
            }

            // Shouldn't goes here
            return null;
        }
    }

    /**
     * The Domain of the Trouble Code. (The second letter of the DTC)
     *
     * @author MacFJA
     */
    public enum
    Domain {
        Standard(0),
        Manufacturer(1),
        Custom2(2), // Shouldn't be used
        Custom3(3); // Shouldn't be used

        private final int code;

        Domain(int code) {
            this.code = code;
        }

        /**
         * <p>Get the Trouble Code Domain from its code.</p>
         * <p>{@code code} is normally {@code 0} or {@code 1}. Other values are not defined in the standard.</p>
         *
         * @param code The domain code to search
         * @return The domain
         * @throws IndexOutOfBoundsException If {@code code} is less than 0 or more than 3 (code is a 2 bits value)
         */
        public static Domain getDomain(int code) {
            if (code < 0 || code > 3) {
                throw new IndexOutOfBoundsException(
                        "Domain code is a 2 bits value, therefor can only vary between 0 and 3 (both included)"
                );
            }

            for (Domain domain : values()) {
                if (domain.code == code) {
                    return domain;
                }
            }

            // Shouldn't goes here
            return null;
        }
    }
}