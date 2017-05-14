
package Guitar.entity;


public enum Type {
	ACOUSTIC, ELECTRIC;
	//不区分大小写	
	  public String toString() {
	    switch(this) {
	      case ACOUSTIC: return "acoustic";
	      case ELECTRIC: return "electric";
	      default:       return "unspecified";
	    }
	  }

}
