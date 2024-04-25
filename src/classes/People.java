package classes;

import java.io.Serializable;

public abstract class People implements Serializable {
	private String name;
	
	public People(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

