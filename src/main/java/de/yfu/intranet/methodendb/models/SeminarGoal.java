package de.yfu.intranet.methodendb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static de.yfu.intranet.methodendb.models.SeminarGoal.SEMINAR_GOAL_TABLE;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

/**
 * @author Alex Senger <alexander.senger@yfu-deutschland.de>
 */
@Entity
@Table(name=SEMINAR_GOAL_TABLE)
public class SeminarGoal {
	
	public static final String SEMINAR_GOAL_TABLE = "sg_seminar_goal";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sg_id")
	private UUID id;
	
	@Column(name="sg_name")
	private String name;
	
	@Column(name="sg_description")
	private String description;

	@ManyToOne
	@JoinColumn(name="sg_seminar_type_id")
	private SeminarType seminarType;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="mm_method_seminar_goal",
			joinColumns = @JoinColumn(name="mm_seminar_goal_id", referencedColumnName = "sg_id"),
			inverseJoinColumns = @JoinColumn(name="mm_method_id", referencedColumnName = "mm_id"))
	private Set<Method> methods;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SeminarType getSeminarType() {
		return seminarType;
	}

	public void setSeminarType(SeminarType seminarType) {
		this.seminarType = seminarType;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
	}

	public Set<Method> getMethods() {
		return this.methods;
	}
}
