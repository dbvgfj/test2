
package Guitar.entity;


public enum Type {
	ACOUSTIC, ELECTRIC;
	//�����ִ�Сд	
	  public String toString() {
	    switch(this) {
	      case ACOUSTIC: return "acoustic";
	      case ELECTRIC: return "electric";
	      default:       return "unspecified";
	    }
	  }

}
