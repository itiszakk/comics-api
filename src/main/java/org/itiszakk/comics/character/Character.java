package org.itiszakk.comics.character;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(schema = "comics", name = "character")
public class Character {

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
    private String imageUrl;
}
