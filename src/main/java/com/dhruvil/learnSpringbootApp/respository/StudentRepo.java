package com.dhruvil.learnSpringbootApp.respository;
import com.dhruvil.learnSpringbootApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// query for data-access layer
@Repository // optional to write coz just an interface
public interface StudentRepo extends JpaRepository <Student , Long >  {

}
