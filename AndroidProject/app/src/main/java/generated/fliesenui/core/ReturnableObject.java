package generated.fliesenui.core;

public class ReturnableObject<K> {
	private K object;
	
	public ReturnableObject(K object){
		this.object = object;
	}
	
	public ReturnableObject(){
		this(null);
	}
	
	public K getObject() {
		return get();
	}
	
	public void setObject(K object) {
		set(object);
	}

	public K get() {
		return object;
	}
	
	public void set(K object) {
		this.object = object;
	}
}
