package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "visitor_comment", schema = "information")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VisitorComment implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date_and_time")
    private LocalDateTime dateTime;

}
