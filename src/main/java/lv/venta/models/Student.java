package lv.venta.models;

import java.util.Collection;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Ids") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ids;

	@Column(name = "Name") // DB pusē izveidosies kolonna "Name"
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam")
	@Size(min = 3, max = 30)
	private String name;

	@Column(name = "Surname") // DB pusē izveidosies kolonna "Surname"
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam")
	@Size(min = 3, max = 30)
	private String surname;

	@OneToMany(mappedBy = "student")
	private Collection<Grade> grades;

	public Student(
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 3, max = 30) String name,
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 3, max = 30) String surname) {
		this.name = name;
		this.surname = surname;
	}

}
