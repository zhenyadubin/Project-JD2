package enams;

import lombok.Getter;

@Getter
public enum Role {

    AUTHOR("Автор"),
    VISITOR("Посетитель"),
    ADMINISTRATOR("Администратор");

    private String description;

    Role(String description) {
        this.description = description;
    }
}
