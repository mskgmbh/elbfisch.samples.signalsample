package org.elbfisch.samples.signalsample;

import org.jpac.AbstractModule;
import org.jpac.CharString;
import org.jpac.Decimal;
import org.jpac.Generic;
import org.jpac.InputInterlockException;
import org.jpac.Logical;
import org.jpac.Module;
import org.jpac.OutputInterlockException;
import org.jpac.PeriodOfTime;
import org.jpac.ProcessException;
import org.jpac.SignedInteger;

public class SignalDemoModule extends Module {
	private Logical 		toggleSignal;
	
	private CharString      charStringSignal;
	private Decimal		    decimalSignal;
	private Logical         logicalSignal;
	private SignedInteger   signedIntegerSignal;
	
	private Generic         genericSignal;
	
	
	protected SignalDemoModule(AbstractModule containingModule){
        super(containingModule);
        initialize();
    }

	protected SignalDemoModule(AbstractModule containingModule, String name) {
		super(containingModule, name);
		initialize();
	}
	
	private void initialize() {
		try {
			toggleSignal        = new Logical(this, "toggle");
			charStringSignal    = new CharString(this, "charString");
			decimalSignal       = new Decimal(this, "decimal");
			signedIntegerSignal = new SignedInteger(this, "signedInteger");
			logicalSignal       = new Logical(this, "flag");
		}
		catch(Exception ex) {
			System.out.println("Error:");
			ex.printStackTrace();
		}
	}

	@Override
	protected void work() throws ProcessException {
		PeriodOfTime toggleTime         = new PeriodOfTime(1 * sec);//instantiate a period of time event (1 s)
        int           cycleCounter       = 0;
        Log.info("started ...");
        
        logicalSignal.set(false);
        toggleSignal.set(false);
        signedIntegerSignal.set(0);
        decimalSignal.set(0.0);
        charStringSignal.set("");
        
        do{
            if (++cycleCounter % 10 == 0){
                charStringSignal.set("Test-String");
                decimalSignal.set(decimalSignal.get() + 0.5);
                signedIntegerSignal.set(signedIntegerSignal.get() + 1);
            }
            if(cycleCounter % 3 == 0) {
            	charStringSignal.set("");
            }
            toggleTime.await();//wait for 1 second}
            toggleSignal.set(!toggleSignal.is(true));
            //Log.info("toggled " + pin4);
        }
        while(true);    
		
	}

	@Override
	protected void preCheckInterlocks() throws InputInterlockException {
	}

	@Override
	protected void postCheckInterlocks() throws OutputInterlockException {	
	}

	@Override
	protected void inEveryCycleDo() throws ProcessException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}
}