package Guitar.dao;
import java.util.List;

import Guitar.entity.*;
public interface  ID {
	public List search(Guitar searchGuitar) ;	
	public Guitar getGuitar(String serialNumber) ;	
}
