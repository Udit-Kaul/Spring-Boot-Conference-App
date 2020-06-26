package com.conferenceapp.conferenceapp.controllers;

import com.conferenceapp.conferenceapp.models.Speaker;
import com.conferenceapp.conferenceapp.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository repository;

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return repository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return repository.saveAndFlush(speaker);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speaker existingSpeaker = repository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        return repository.saveAndFlush(existingSpeaker);
    }

}
