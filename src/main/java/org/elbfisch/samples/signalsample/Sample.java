/**
 * PROJECT   : Elbfisch - java process automation controller (jPac)
 * MODULE    : Sample.java
 * VERSION   : -
 * DATE      : -
 * PURPOSE   : 
 * AUTHOR    : Andreas Ulbrich, MSK Gesellschaft fuer Automatisierung mbH, Schenefeld
 * REMARKS   : -
 * CHANGES   : CH#n <Kuerzel> <datum> <Beschreibung>
 *
 * This file is part of the jPac process automation controller.
 * jPac is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jPac is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the jPac If not, see <http://www.gnu.org/licenses/>.
 */
package org.elbfisch.samples.signalsample;

import java.nio.charset.Charset;
import org.jpac.Module;
import org.jpac.fx.DashboardLauncher;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Andreas Ulbrich
 */
public class Sample extends javafx.application.Application {
	/**
	 * 
	 * @param sttage - the fx stage
	 */
	@Override
	public void start(Stage stage) throws Exception {
		boolean handles = false;
        System.out.println("Default Charset=" + Charset.defaultCharset());
        try{
             Module mod      = new MainModule(null, "Main");
             mod.start();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        try{
            stage.initStyle(StageStyle.DECORATED);
            DashboardLauncher dashboardLauncher = new DashboardLauncher();
            dashboardLauncher.show();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
	}
	
	@Override
    public void stop() {
        System.exit(0);
    }
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        	launch(args);
        }
        catch(Exception ex) {
        	System.out.println("Error: ");
        	ex.printStackTrace();
        }
        catch(Error err) {
        	System.out.println("Error: ");
        	err.printStackTrace();
        }
    } 
}