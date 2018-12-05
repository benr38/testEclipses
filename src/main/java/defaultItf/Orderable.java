package defaultItf;

public interface Orderable<T> extends Comparable<T>{
	
	default boolean estIdentique(T obj) {
		return this.compareTo(obj)==0 ;
	}
	default boolean  plusGrandQue(T obj) {
		return this.compareTo(obj) > 0 ;
	}
	default boolean  plusPetitQue(T obj) {
		return this.compareTo(obj) < 0 ;
	}

}
