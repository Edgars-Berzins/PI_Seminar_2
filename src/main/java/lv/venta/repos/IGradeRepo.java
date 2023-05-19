package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long> {
	ArrayList<Grade> findByStudentIds(long ids); // atlasa visas atzīmes, ja ir zināms id

	ArrayList<Grade> findByCourseTitle(String title); // atlasa kursa arzīmes, ja i zināms kursa nosaukums

}
