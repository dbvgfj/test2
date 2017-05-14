
package Guitar.servlet;

import Guitar.dao.ID;
import Guitar.dao.impl.*;
import Guitar.entity.*;
import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

	public static void main(String[] args) {

		ID inventory = new Inventory();
		
		Guitar whatErinLikes = new Guitar("", 0, Builder.FENDER, "Stratocastor", 
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		List matchingGuitars = inventory.search(whatErinLikes);
		if (!matchingGuitars.isEmpty()) {
			System.out.println("Erin, you might like these guitars:");
			for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
				Guitar guitar = (Guitar)i.next();
				System.out.println("  We have a " +
			          guitar.getBuilder() + " " + guitar.getModel() + " " +
			          guitar.getType() + " guitar:\n     " +
			          guitar.getBackWood() + " back and sides,\n     " +
			          guitar.getTopWood() + " top.\n  You can have it for only $" +
			          guitar.getPrice() + "!\n  ----");
			}
		}else{
			System.out.println("Sorry, Erin, we have nothing for you.");
		}
	}


}
