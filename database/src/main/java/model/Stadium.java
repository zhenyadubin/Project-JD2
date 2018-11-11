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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stadium", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "footballClub")
public class Stadium extends BaseModel<Integer> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(mappedBy = "stadium", fetch = FetchType.LAZY)
    private FootballClub footballClub;
}
