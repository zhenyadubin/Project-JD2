package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "country", schema = "information")
@ToString(exclude = {"cities", "leagues", "coaches", "players", "news"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Country implements BaseModel<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new HashSet<>();

    @OneToMany(mappedBy = "country")
    private List<League> leagues = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Coach> coaches = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "countries")
    private List<News> news = new ArrayList<>();
}
