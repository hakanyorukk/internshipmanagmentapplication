package org.example.internship_system.repository;

import org.example.internship_system.entity.StudentProfile;
import org.example.internship_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    Optional<StudentProfile> findByUser(User user);

    Optional<StudentProfile> findByUserId(Long userId);
}
