package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StadiumFullInfoDto {

    private int id;
    private String name;
    private int numberOfSeats;
    private String city;

}
