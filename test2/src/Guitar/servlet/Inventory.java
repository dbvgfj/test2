
package Guitar.servlet;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;

import Guitar.dao.impl.GuitarSpec;
import Guitar.entity.Guitar;


public class Inventory {
	private List guitars;
	public Inventory() {
		guitars = new LinkedList();
	}

	
	public List search(GuitarSpec searchSpec) {
		List matchingGuitars = new LinkedList();
		for (Iterator i = guitars.iterator(); i.hasNext(); ) {
			Guitar guitar = (Guitar)i.next();
			if (guitar.getSpec().matches(searchSpec)){
				matchingGuitars.add(guitar);
			}				
		}
		return matchingGuitars;
	}
}
