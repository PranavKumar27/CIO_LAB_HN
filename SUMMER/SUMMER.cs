using System;
using Eclr;
using System.Iec61131Lib;
using System.Runtime.InteropServices;



namespace SUMMER
{
    /***    Start of Managed Unit Conversion Blocks   ***/
    [FUNCTION_BLOCK]
    [Managed]
    public class SUMMER
    {
        // Function block interface
        [VAR_INPUT("LREAL")]
        public double P1;

        [VAR_INPUT("LREAL")]
        public double P2;

        [VAR_INPUT("LREAL")]
        public double P3;

        [VAR_INPUT("LREAL")]
        public double P4;

        [VAR_INPUT("LREAL")]
        public double P5;

        [VAR_INPUT("LREAL")]
        public double P6;

        [VAR_INPUT("LREAL")]
        public double P7;

        [VAR_INPUT("LREAL")]
        public double P8;

        [VAR_INPUT("LREAL")]
        public double C1;

        [VAR_INPUT("LREAL")]
        public double C2;

        [VAR_INPUT("LREAL")]
        public double C3;

        [VAR_INPUT("LREAL")]
        public double C4;

        [VAR_INPUT("LREAL")]
        public double C5;

        [VAR_INPUT("LREAL")]
        public double C6;

        [VAR_INPUT("LREAL")]
        public double C7;

        [VAR_INPUT("LREAL")]
        public double C8;

        [VAR_INPUT("LREAL")]
        public double D1;

        [VAR_INPUT("LREAL")]
        public double D2;

        [VAR_INPUT("LREAL")]
        public double D3;

        [VAR_INPUT("LREAL")]
        public double D4;

        [VAR_INPUT("LREAL")]
        public double D5;

        [VAR_INPUT("LREAL")]
        public double D6;

        [VAR_INPUT("LREAL")]
        public double D7;

        [VAR_INPUT("LREAL")]
        public double D8;

        [VAR_INPUT("LREAL")]
        public double CPV;

        [VAR_INPUT("LREAL")]
        public double DPV;

        [VAR_OUTPUT("LREAL")]
        public double PV;


        public SUMMER()
        {

        }
        public void __Init()
        {
            C1 = C2 = C3 = C4 = C5 = C6 = C7 = C8 = CPV = 1;
            D1 = D2 = D3 = D4 = D5 = D6 = D7 = D8 = DPV = 0;
        }

        public void __Process()
        {
            double Val1 = C1 * P1 + D1;
            double Val2 = C2 * P2 + D2;
            double Val3 = C3 * P3 + D3;
            double Val4 = C4 * P4 + D4;
            double Val5 = C5 * P5 + D5;
            double Val6 = C6 * P6 + D6;
            double Val7 = C7 * P7 + D7;
            double Val8 = C8 * P8 + D8;

            PV = (CPV*(Val1+Val2+Val3+Val4+Val5+Val6+Val7+Val8))+DPV;
        }
    } //End of SUMMER Function Block

} // End of SUMMER namespace
