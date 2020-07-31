package org.elbfisch.samples.signalsample;

import org.jpac.AbstractModule;
import org.jpac.ImpossibleEvent;
import org.jpac.InputInterlockException;
import org.jpac.Module;
import org.jpac.OutputInterlockException;
import org.jpac.ProcessException;

public class MainModule extends Module {
	
	protected MainModule(AbstractModule containingModule){
        super(containingModule);
    }

	protected MainModule(AbstractModule containingModule, String name) {
		super(containingModule, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void work() throws ProcessException {
		new ImpossibleEvent().await();		
	}

	@Override
	public void start() {
		try {
			//invoke my containing modules
			new SignalDemoModule(this, "SignalDemoModule").start();
			//then start myself
			super.start();
		}
		catch(Exception ex) {
			Log.error("Error: ", ex);
		}
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