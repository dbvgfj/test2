

package Guitar.dao.impl;

import Guitar.dao.ID;
import Guitar.entity.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Inventory implements ID {
	private List guitars;


	public Inventory() {
		this.guitars = new LinkedList();
	}
	
	public Guitar getGuitar(String serialNumber) {
	    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSerialNumber().equals(serialNumber)) {
	        return guitar;
	      }
	    }
	    return null;
	  }
	
	public List search(Guitar searchGuitar) {
	    List matchingGuitars = new LinkedList();
	    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (searchGuitar.getBuilder() != guitar.getBuilder())
	        continue;
	      String model = searchGuitar.getModel().toLowerCase();
	      if ((model != null) && (!model.equals("")) &&
	          (!model.equals(guitar.getModel().toLowerCase())))
	        continue;
	      if (searchGuitar.getType() != guitar.getType())
	        continue;
	      if (searchGuitar.getBackWood() != guitar.getBackWood())
	        continue;
	      if (searchGuitar.getTopWood() != guitar.getTopWood())
	        continue;
	      matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  }
}
