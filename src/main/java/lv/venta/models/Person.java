package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idpe") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
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

	public Person(
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 3, max = 30) String name,
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 3, max = 30) String surname) {
		this.name = name;
		this.surname = surname;
	}

}
