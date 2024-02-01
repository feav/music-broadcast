package com.music.distribution.controller;

import com.music.distribution.dto.MusicDTO;
import com.music.distribution.entity.Music;
import com.music.distribution.exception.NotFoundEntityException;
import com.music.distribution.service.MusicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/productions/")
@CrossOrigin(origins = "*", allowCredentials = "false")
class MusicController {
    @Autowired(required = false)
    private MusicService musicService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<MusicDTO> get(@PathVariable("id") Long id) throws NotFoundEntityException {
        Music music =  this.musicService.get(id);
        return new ResponseEntity<>( this.modelMapper.map(music, MusicDTO.class), HttpStatus.OK );
    }
    @GetMapping()
    public ResponseEntity<List<MusicDTO>> getAll(){
        List<MusicDTO> productions = musicService
                .getAll()
                .stream()
                .map(prod -> this.modelMapper.map(prod, MusicDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(productions, HttpStatus.OK );
    }
    @GetMapping("page")
    public Page<Music> getPaginatedMusics(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return musicService.getPaginatedMusics(--page, size);
    }
}
