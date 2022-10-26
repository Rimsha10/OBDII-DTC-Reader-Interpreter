package com.example.mydtcreader.enums;

public enum Description {

    //DTC Codes - P0100-P0199 – Fuel and Air Metering//
    P1616("SAS control module malfunction Open or short circuit "),
    P1106("BARO_Sensor_Circuit_Range_Performance_Malfunction"),
    P1107("BARO_Circuit_Low_Input"),
    P0100("Mass_or_Volume_Air_Flow_Circuit_Malfunction"),
    P0101("Mass_or_Volume_Air_Flow_Circuit_Range/Performance_Problem"),
    P0102("Mass or Volume Air Flow Circuit Low Input"),
    P0103("Mass or Volume Air Flow Circuit High Input"),
    P0104("Mass or Volume Air Flow Circuit Intermittent"),
    P0105("Manifold Absolute Pressure/Barometric Pressure Circuit Malfunction"),
    P0106("Manifold Absolute Pressure/Barometric Pressure Circuit Range/Performance Problem"),
    P0107("Manifold Absolute Pressure/Barometric Pressure Circuit Low Input"),
    P0108("Manifold Absolute Pressure/Barometric Pressure Circuit High Input"),
    P0109("Manifold Absolute Pressure/Barometric Pressure Circuit Intermittent"),
    P0110("Intake Air Temperature Circuit Malfunction"),
    P0111("Intake Air Temperature Circuit Range/Performance Problem"),
    P0112("Intake Air Temperature Circuit Low Input"),
    P0113("Intake Air Temperature Circuit High Input"),
    P0114("Intake Air Temperature Circuit Intermittent"),
   /* P0115 Engine Coolant Temperature Circuit Malfunction
    P0116 Engine Coolant Temperature Circuit Range/Performance Problem
    P0117 Engine Coolant Temperature Circuit Low Input
    P0118 Engine Coolant Temperature Circuit High Input
    P0119 Engine Coolant Temperature Circuit Intermittent
    P0120 Throttle/Petal Position Sensor/Switch A Circuit Malfunction
    P0121 Throttle/Petal Position Sensor/Switch A Circuit Range/Performance Problem
    P0122 Throttle/Petal Position Sensor/Switch A Circuit Low Input
    P0123 Throttle/Petal Position Sensor/Switch A Circuit High Input
    P0124 Throttle/Petal Position Sensor/Switch A Circuit Intermittent
    P0125 Insufficient Coolant Temperature for Closed Loop Fuel Control
    P0126 Insufficient Coolant Temperature for Stable Operation
    P0130 02 Sensor Circuit Malfunction (Bank I Sensor 1)
    P0131 02 Sensor Circuit Low Voltage (Bank I Sensor I)
    P0132 02 Sensor Circuit High Voltage (Bank I Sensor 1)
    P0133 02 Sensor Circuit Slow Response (Bank 1 Sensor 1)
    P0134 02 Sensor Circuit No Activity Detected (Bank I Sensor 1)
    P0135 02 Sensor Heater Circuit Malfunction (Bank 1 Sensor 1)
    P0136 02 Sensor Circuit Malfunction (Bank I Sensor 2)
    P0137 02 Sensor Circuit Low Voltage (Bank I Sensor 2)
    P0138 02 Sensor Circuit High Voltage (Bank I Sensor 2)
    P0139 02 Sensor Circuit Slow Response (Bank 1 Sensor 2)
    P0140 02 Sensor Circuit No Activity Detected (Bank 1 Sensor 2)
    P0141 02 Sensor Heater Circuit Malfunction (Bank 1 Sensor 2)
    P0142 02 Sensor Circuit Malfunction (Bank I Sensor 3)
    P0143 02 Sensor Circuit Low Voltage (Bank I Sensor 3)
    P0144 02 Sensor Circuit High Voltage (Bank I Sensor 3)
    P0145 02 Sensor Circuit Slow Response (Bank 1 Sensor 3)
    P0146 02 Sensor Circuit No Activity Detected (Bank I Sensor 3)
    P0147 02 Sensor Heater Circuit Malfunction (Bank I Sensor 3)
    P0150 02 Sensor Circuit Malfunction (Bank 2 Sensor I)
    P0151 02 Sensor Circuit Low Voltage (Bank 2 Sensor I)
    P0152 02 Sensor Circuit High Voltage (Bank 2 Sensor 1)
    P0153 02 Sensor Circuit Slow Response (Bank 2 Sensor 1)
    P0154 02 Sensor Circuit No Activity Detected (Bank 2 Sensor 1)
    P0155 02 Sensor Heater Circuit Malfunction (Bank 2 Sensor 1)
    P0156 02 Sensor Circuit Malfunction (Bank 2 Sensor 2)
    P0157 02 Sensor Circuit Low Voltage (Bank 2 Sensor 2)
    P0158 02 Sensor Circuit High Voltage (Bank 2 Sensor 2)
    P0159 02 Sensor Circuit Slow Response (Bank 2 Sensor 2)
    P0160 02 Sensor Circuit No Activity Detected (Bank 2 Sensor 2)
    P0161 02 Sensor Heater Circuit Malfunction (Bank 2 Sensor 2)
    P0162 02 Sensor Circuit Malfunction (Bank 2 Sensor 3)
    P0163 02 Sensor Circuit Low Voltage (Bank 2 Sensor 3)
    P0164 02 Sensor Circuit High Voltage (Bank 2 Sensor 3)
    P0165 02 Sensor Circuit Slow Response (Bank 2 Sensor 3)
    P0166 02 Sensor Circuit No Activity Detected (Bank 2 Sensor 3)
    P0167 02 Sensor Heater Circuit Malfunction (Bank 2 Sensor 3)
    P0170 Fuel Trim Malfunction (Bank 1)
    P0171 System too Lean (Bank 1)
    P0172 System too Rich (Bank 1)
    P0173 Fuel Trim Malfunction (Bank 2)
    P0174 System too Lean (Bank 2)
    P0175 System too Rich (Bank 2)
    P0176 Fuel Composition Sensor Circuit Malfunction
    P0177 Fuel Composition Sensor Circuit Range/Performance
    P0178 Fuel Composition Sensor Circuit Low Input
    P0179 Fuel Composition Sensor Circuit High Input
    P0180 Fuel Temperature Sensor A Circuit Malfunction
    P0181 Fuel Temperature Sensor A Circuit Range/Performance
    P0182 Fuel Temperature Sensor A Circuit Low Input
    P0183 Fuel Temperature Sensor A Circuit High Input
    P0184 Fuel Temperature Sensor A Circuit Intermittent
    P0185 Fuel Temperature Sensor B Circuit Malfunction
    P0186 Fuel Temperature Sensor B Circuit Range/Performance
    P0187 Fuel Temperature Sensor B Circuit Low Input*/
    P0188("Fuel Temperature Sensor B Circuit High Input"),
    P0189("Fuel Temperature Sensor B Circuit Intermittent"),
    P0190("Fuel Rail Pressure Sensor Circuit Malfunction"),
    P0191("Fuel Rail Pressure Sensor Circuit Range/Performance"),
    P0192("Fuel Rail Pressure Sensor Circuit Low Input"),
    P0193("Fuel Rail Pressure Sensor Circuit High Input"),
    P0194("Fuel Rail Pressure Sensor Circuit Intermittent"),
    P0195("Engine Oil Temperature Sensor Malfunction"),
    P0196("Engine Oil Temperature Sensor Range/Performance"),
    P0197("Engine Oil Temperature Sensor Low"),
    P0198("Engine Oil Temperature Sensor High"),
    P0199("Engine Oil Temperature Sensor Intermitten"),

    //DTC Codes - P0200-P0299 – Fuel and Air Metering (Injector Circuit)//
    P0200("Injector Circuit Malfunction"),
    P0201("Injector Circuit Malfunction - Cylinder 1"),
    P0202("Injector Circuit Malfunction - Cylinder 2"),
    P0203 ("Injector Circuit Malfunction - Cylinder 3"),
    P0204 ("Injector Circuit Malfunction - Cylinder 4"),
    P0205 ("Injector Circuit Malfunction - Cylinder 5"),
    P0206 ("Injector Circuit Malfunction - Cylinder 6"),
    P0207 ("Injector Circuit Malfunction - Cylinder 7"),
    P0208 ("Injector Circuit Malfunction - Cylinder 8"),
    P0209 ("Injector Circuit Malfunction - Cylinder 9"),
    P0210 ("Injector Circuit Malfunction - Cylinder 10"),
    P0211 ("Injector Circuit Malfunction - Cylinder 11"),
    P0212 ("Injector Circuit Malfunction - Cylinder 12"),
    P0213 ("Cold Start Injector 1 Malfunction"),
    P0214 ("Cold Start Injector 2 Malfunction"),
    P0215 ("Engine Shutoff Solenoid Malfunction"),
    P0216 ("Injection Timing Control Circuit Malfunction"),
    P0217 ("Engine Overtemp Condition"),
    P0218 ("Transmission Over Temperature Condition"),
    P0219 ("Engine Overspeed Condition"),
    P0220 ("Throttle/Petal Position Sensor/Switch B Circuit Malfunction"),
    P0221 ("Throttle/Petal Position Sensor/Switch B Circuit Range/Performance Problem"),
    //......

    //DTC Codes - P0300-P0399 – Ignition System or Misfire//
    P0300 ("Random/Multiple Cylinder Misfire Detected"),
    P0301 ("Cylinder 1 Misfire Detected"),
    P0302 ("Cylinder 2 Misfire Detected"),
    P0303 ("Cylinder 3 Misfire Detected"),
    P0304 ("Cylinder 4 Misfire Detected"),
    P0305 ("Cylinder 5 Misfire Detected"),
    P0306 ("Cylinder 6 Misfire Detected"),
    P0307 ("Cylinder 7 Misfire Detected"),
    P0308 ("Cylinder 8 Misfire Detected"),
    P0309 ("Cylinder 9 Misfire Detected"),
    //.....

    //DTC Codes - P0400-P0499 – Auxiliary Emissions Controls//
    P0400 ("Exhaust Gas Recirculation Flow Malfunction"),
    P0401 ("Exhaust Gas Recirculation Flow Insufficient Detected"),
    P0402 ("Exhaust Gas Recirculation Flow Excessive Detected"),
    P0403 ("Exhaust Gas Recirculation Circuit Malfunction"),
    P0404 ("Exhaust Gas Recirculation Circuit Range/Performance"),
    P0405 ("Exhaust Gas Recirculation Sensor A Circuit Low"),
    P0406 ("Exhaust Gas Recirculation Sensor A Circuit High"),
    P0407 ("Exhaust Gas Recirculation Sensor B Circuit Low"),
    P0408 ("Exhaust Gas Recirculation Sensor B Circuit High"),
    P0410 ("Secondary Air Injection System Malfunction"),
    //.....

    //DTC Codes - P0500-P0599 – Vehicle Speed Controls and Idle Control System
    P0500 ("Vehicle Speed Sensor Malfunction"),
    P0501 ("Vehicle Speed Sensor Range/Performance"),
    P0502 ("Vehicle Speed Sensor Low Input"),
    P0503 ("Vehicle Speed Sensor Intermittent/Erratic/High"),
    P0505 ("Idle Control System Malfunction"),
    P0506 ("Idle Control System RPM Lower Than Expected"),
    P0507 ("Idle Control System RPM Higher Than Expected"),
    P0510 ("Closed Throttle Position Switch Malfunction"),
    //....

    //DTC Codes - P0600-P0699 – Computer Output Circuit
    P0600 ("Serial Communication Link Malfunction"),
    P0601 ("Internal Control Module Memory Check Sum Error"),
    P0602 ("Control Module Programming Error"),
    P0603 ("Internal Control Module Keep Alive Memory (KAM) Error"),
    P0604 ("Internal Control Module Random Access Memory (RAM) Error"),
    P0605 ("Internal Control Module Read Only Memory (ROM) Error"),
    P0606 ("PCM Processor Fault"),
    P0608 ("Control Module VSS Output 'A’ Malfunction"),
    P0609 ("Control Module VSS Output 'B' Malfunction"),
    P0620 ("Generator Control Circuit Malfunction"),
    //....

    //DTC Codes - P0700-P0899 – Transmission
    P0700("Transmission Control System Malfunction"),
    P0701 ("Transmission Control System Range/Performance"),
    P0702 ("Transmission Control System Electrical"),
    P0703 ("Torque Converter/Brake Switch B Circuit Malfunction"),
    P0704 ("Clutch Switch Input Circuit Malfunction"),
    P0705 ("Transmission Range Sensor Circuit malfunction (PRNDL Input)"),
    P0706 ("Transmission Range Sensor Circuit Range/Performance"),
    P0707 ("Transmission Range Sensor Circuit Low Input"),
    P0708 ("Transmission Range Sensor Circuit High Input"),
    P0709 ("Transmission Range Sensor Circuit Intermittent"),
    P0710( "Transmission Fluid Temperature Sensor Circuit Malfunction");
    //....





    private final String troublecode;

    Description(String troublecode){
        this.troublecode = troublecode;
    }

    public String getTroublecode(){return this.troublecode;}

    public static String getDescription(String troublecodename) {

        for (Description d : Description.values()) {
            if (d.toString().equals(troublecodename)) {
                System.out.println((d.toString().equals(troublecodename)));
                return d.getTroublecode();
            }
            }
        //}
        return null;
    }
}
