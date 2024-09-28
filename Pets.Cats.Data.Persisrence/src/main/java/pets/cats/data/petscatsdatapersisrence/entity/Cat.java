package pets.cats.data.petscatsdatapersisrence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "cats",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Cat {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "color")
    private String color;

    @Column(name = "owner_id")
    private UUID ownerId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_friendships",
            joinColumns = {@JoinColumn(name = "cat1_id")},
            inverseJoinColumns = {@JoinColumn(name = "cat2_id")})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Cat> friendCats;

    public Cat(
            UUID id,
            LocalDate birthDate,
            String name,
            String breed,
            String color,
            UUID ownerId,
            Set<Cat> friendCats) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.ownerId = ownerId;
        this.friendCats = friendCats;
        if (friendCats == null) {
            this.friendCats = new HashSet<>();
        }
    }
}