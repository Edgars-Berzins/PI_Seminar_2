package lv.venta.models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

@Table(name = "grade_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idg") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg;

	@Column(name = "Grade_Value") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Min(value = 0)
	@Max(value = 10)
	private int gradeValue;

	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "Idc")
	private Course course;

	public Grade(@Min(0) @Max(10) int gradeValue, Student student, Course course) {
		this.gradeValue = gradeValue;
		this.student = student;
		this.course = course;
	}

}
