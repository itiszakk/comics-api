package com.itiszakk.comics.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "comics", name = "character")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "alignment")
    private CharacterAlignment alignment;

    @Column(name = "publisher")
    private ComicsPublisher publisher;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageURL;
}
