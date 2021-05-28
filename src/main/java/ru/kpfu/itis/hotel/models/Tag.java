package ru.kpfu.itis.hotel.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

//@Data
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag_hotel")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tagName;

    @ToString.Exclude
    @ManyToMany(mappedBy = "tags")
    private List<News> news;
}
