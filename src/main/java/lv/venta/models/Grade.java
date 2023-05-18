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

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade  {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc") // DB pusē izveidosies kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;

	@Column(name = "Title") // DB pusē izveidosies kolonna "Name"
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam")
	@Size(min = 3, max = 50)
	private String title;

	private Professor professor;

	public Grade(
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burta mjābūt lielajam") @Size(min = 3, max = 50) String title,
			Professor professor) {
		super();
		this.title = title;
		this.professor = professor;
	}
	
	

}
