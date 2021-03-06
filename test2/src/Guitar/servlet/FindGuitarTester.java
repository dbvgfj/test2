
package Guitar.servlet;

import java.util.Iterator;
import java.util.List;

import Guitar.dao.impl.GuitarSpec;
import Guitar.entity.Builder;
import Guitar.entity.Guitar;
import Guitar.entity.Type;
import Guitar.entity.Wood;

public class FindGuitarTester {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
	    GuitarSpec whatErinLikes = 
	    	      new GuitarSpec(Builder.FENDER, "Stratocastor", 
	    	                     Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
	    List matchingGuitars = inventory.search(whatErinLikes);
	    if (!matchingGuitars.isEmpty()) {
	      System.out.println("Erin, you might like these guitars:");
	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	        Guitar guitar = (Guitar)i.next();
	        GuitarSpec spec = guitar.getSpec();
	        System.out.println("  We have a " +
	          spec.getBuilder() + " " + spec.getModel() + " " +
	          spec.getType() + " guitar:\n     " +
	          spec.getBackWood() + " back and sides,\n     " +
	          spec.getTopWood() + " top.\n  You can have it for only $" +
	          guitar.getPrice() + "!\n  ----");
	      }
	    } else {
	      System.out.println("Sorry, Erin, we have nothing for you.");
	    }
	}
	
}
