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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "league", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = {"footballClubs", "news"})
public class League implements BaseModel<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "number_of_clubs", nullable = false)
    private Integer numberOfClubs;

    @OneToMany(mappedBy = "league")
    private Set<FootballClub> footballClubs = new HashSet<>();

    @ManyToMany(mappedBy = "leagues")
    private List<News> news = new ArrayList<>();
}
