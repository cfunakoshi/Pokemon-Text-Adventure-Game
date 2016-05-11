package items;

public class Badge extends Item {
	private String name;
	private String type;
	
	public Badge(String name, String type) {
		super(name);
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
