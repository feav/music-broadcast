package com.music.distribution.batch.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemXML {

    public String title;
    public String description;
    public String link;
    public String image;
    public Date createdAt;
    public Date pubDate;
}
