package bd.edu.diu.cis.fitnesstracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username = "";
	private String password = "";
	private String email = "";
	private String name = "";
	private String gender = "";
	private String weight = "";
	private String height = "";
	private String waistSize = "";
	private int age = 0;

	@OneToMany(mappedBy = "user")
	private List<DailyRecord> dailyRecords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<DailyRecord> getDailyRecords() {
		return dailyRecords;
	}

	public void setDailyRecords(List<DailyRecord> dailyRecords) {
		this.dailyRecords = dailyRecords;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWaistSize() {
		return waistSize;
	}

	public void setWaistSize(String waistSize) {
		this.waistSize = waistSize;
	}

}
