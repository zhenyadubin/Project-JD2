package dao;

import connection.ConnectionPool;
import exception.DaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StadiumDao {

    private static final StadiumDao INSTANCE = new StadiumDao();

    private static final String GET_ALL = "SELECT id, name, number_of_seats, city FROM information.stadium;";

    private static final String GET_BY_ID = "SELECT id, name, number_of_seats, city FROM information.stadium "
            + "WHERE id = ?;";

    public List<Stadium> getAllStadium() {
        List<Stadium> stadiums = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stadiums.add(Stadium.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .numberOfSeats(resultSet.getInt("number_of_seats"))
                        .city(resultSet.getString("city"))
                        .build());
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return stadiums;
    }

    public Stadium getById(Integer id) {
        Stadium stadium = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stadium = stadium.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .numberOfSeats((resultSet.getInt("number_of_seats")))
                        .city(resultSet.getString("city"))
                        .build();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return stadium;
    }

    public static StadiumDao getInstance() {
        return INSTANCE;
    }
}
