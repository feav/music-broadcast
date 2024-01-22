package com.music.distribution.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicDTO {

    public Long id;
    public String title;
    public String description;
    public String link;
    public String image;
    public Date createdAt;
    public Date pubDate;
}
