package de.hdm.gruppe3.stundenplantool.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StundenplanTool implements EntryPoint {
	
	private VerticalPanel mainPanel = new VerticalPanel();
	VerticalPanel vertpan = new VerticalPanel();
	HorizontalPanel hor1 = new HorizontalPanel();
	
	
	
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		
		//COMMAND
		Command dlCmd = new Command(){ 
            public void execute(){ 
               
            } 
        }; 
        
        //COMMAND
      //COMMAND
      		Command cmd = new Command(){ 
                  public void execute(){ 
                     
                  } 
              }; 		
		
		
		
		mainPanel.add(vertpan);
		mainPanel.add(hor1);
              
        MenuBar dlMenu = new MenuBar(true); 
        dlMenu.addItem("Dienstleistung anzeigen", cmd); 
        dlMenu.addItem("Dienstleistung anlegen", dlCmd); 
        
        MenuBar menu = new MenuBar(); 
        menu.addItem("Dienstleistung", dlMenu); 
        
        
        vertpan.add(new HTML("<h1>TESTTESTTEST</h1>"));
        hor1.add(new HTML("<h2>TreePanel</h2>"));
        hor1.setSpacing(5);
        hor1.add(new HTML("<h2>DetailPanel</h2>"));
        vertpan.add(menu);
        
        RootPanel.get("starter").add(mainPanel);
	}
}
