package model;

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
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "city", schema = "information")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"stadiums", "news"})
@AllArgsConstructor
@Data
@Builder
public class City extends BaseModel<Integer> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Stadium> stadiums = new HashSet<>();

    @ManyToMany(mappedBy = "cities")
    private List<News> news = new ArrayList<>();
}
