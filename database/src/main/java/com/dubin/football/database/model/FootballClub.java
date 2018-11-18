package com.dubin.football.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "football_club", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true, exclude = {"players", "news"})
public class FootballClub extends BaseModel<Integer> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToMany(mappedBy = "footballClub")
    private List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "clubs")
    private List<News> news = new ArrayList<>();
}
