package com.conferenceapp.conferenceapp.repositories;

import com.conferenceapp.conferenceapp.models.Session;
import com.conferenceapp.conferenceapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
