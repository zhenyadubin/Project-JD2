package model;

import enams.Role;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "visitor", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = {"news", "comments", "countries", "cities", "leagues", "coaches", "clubs", "players"})
public class Visitor implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visitor_name", unique = true, nullable = false)
    private String name;

    @Column(name = "e_mail", unique = true, nullable = false)
    private String eMail;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<News> news = new ArrayList<>();

    @OneToMany(mappedBy = "visitor")
    private List<VisitorComment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cities = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id")
    )
    private List<League> leagues = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private List<Coach> coaches = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<FootballClub> clubs = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "visitor_tags", schema = "information",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();
}
