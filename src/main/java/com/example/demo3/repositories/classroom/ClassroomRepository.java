package com.example.demo3.repositories.classroom;

import com.example.demo3.persistances.model.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
