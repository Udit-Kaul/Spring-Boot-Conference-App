package com.conferenceapp.conferenceapp.controllers;

import com.conferenceapp.conferenceapp.models.Session;
import com.conferenceapp.conferenceapp.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository repository;

    @GetMapping("{id}")
    public Session get(@PathVariable Long id) {
         return repository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return repository.saveAndFlush(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        //TODO: Also check for children records before deleting
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = repository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return repository.saveAndFlush(existingSession);

    }

}