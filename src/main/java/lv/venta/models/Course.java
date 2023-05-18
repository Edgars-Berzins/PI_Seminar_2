package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;

	@Column(name = "Title") // DB pusē izveidosies kolonna "Name"
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam")
	@Size(min = 5, max = 50)
	private String title;
	@NotNull

	@Column(name = "Credit_Points")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;

	@OneToOne
	@JoinColumn(name = "Idp") // foreign key
	private Professor professor;

	@OneToMany(mappedBy = "course")
	private Collection<Grade> grades;

	public Course(
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 5, max = 50) String title,
			@NotNull @Min(1) @Max(20) int creditPoints, Professor professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	};
	
	

}
