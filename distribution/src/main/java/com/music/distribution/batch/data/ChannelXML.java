package com.music.distribution.batch.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChannelXML {
    private String title;
    private String description;
    private Date pubDate;
    private String link;
    private String guid;
    private String enclosureUrl;
    List<ItemXML> items;
}
