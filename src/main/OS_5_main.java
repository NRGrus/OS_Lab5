package main;

import javax.swing.SwingUtilities;

import memoryManagement.MemoryManagement;

public class OS_5_main {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() { 
    		public void run() { 
    			new MemoryManagement(); 
    			} 
    		});
	}
}