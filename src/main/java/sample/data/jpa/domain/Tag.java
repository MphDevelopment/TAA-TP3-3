package sample.data.jpa.domain;
import javax.persistence.*;

@Entity
public class Tag {
	
	private String name;
	
	public Tag(String name) {
		this.name = name;
	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
