package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;

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

	@Column(name = "Degree") // DB pusē izveidosies kolonna "Degree"
	@NotBlank
	private Degree degree;

	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}

}