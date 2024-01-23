package com.music.distribution.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    @Lob
    @Column(length = 1000)
    public String description;
    public String link;
    public String image;
    public Date createdAt;
    public Date pubDate;
}
