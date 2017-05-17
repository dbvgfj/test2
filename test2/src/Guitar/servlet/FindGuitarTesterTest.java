package Guitar.servlet;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Guitar.dao.impl.GuitarSpec;
import Guitar.entity.Builder;
import Guitar.entity.Guitar;
import Guitar.entity.Type;
import Guitar.entity.Wood;

public class FindGuitarTesterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() {
		Inventory inventory = new Inventory();
	    GuitarSpec whatErinLikes = 
	    	      new GuitarSpec(Builder.FENDER, "Stratocastor", 
	    	                     Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
	    List matchingGuitars = inventory.search(whatErinLikes);
	    if (!matchingGuitars.isEmpty()) {
	      System.out.println(" you might like these guitars:");
	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	        Guitar guitar = (Guitar)i.next();
	        GuitarSpec spec = guitar.getSpec();
	       
	      }
	    } else {
	      System.out.println("Sorry, we have nothing for you.");
	    }
	}

}
