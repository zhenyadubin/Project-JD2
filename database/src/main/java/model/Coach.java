package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "coach", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = {"footballClub", "news"})
public class Coach extends BaseModel<Integer> {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(mappedBy = "coach", fetch = FetchType.LAZY)
    private FootballClub footballClub;

    @ManyToMany(mappedBy = "coaches")
    private List<News> news = new ArrayList<>();
}
