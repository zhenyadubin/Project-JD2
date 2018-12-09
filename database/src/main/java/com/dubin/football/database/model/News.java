package com.dubin.football.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "news", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true, exclude = {"comments", "countries", "cities", "leagues", "coaches", "clubs", "players"})
public class News extends BaseModel<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Visitor author;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "news")
    private List<VisitorComment> comments = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cities = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id")
    )
    private List<League> leagues = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private List<Coach> coaches = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<FootballClub> clubs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", schema = "information",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();
}
