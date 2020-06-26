package com.conferenceapp.conferenceapp.repositories;

import com.conferenceapp.conferenceapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
