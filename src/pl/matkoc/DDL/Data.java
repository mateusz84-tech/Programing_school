package pl.matkoc.DDL;

public class Data {

    private final String exercise = "CREATE TABLE exercise(\n" +
            "    id_exercise INT AUTO_INCREMENT,\n" +
            "    title VARCHAR(255),\n" +
            "    description TEXT,\n" +
            "    PRIMARY KEY (id_exercise));";

    private final String group = "CREATE TABLE user_group(\n" +
            "    id_group INT AUTO_INCREMENT,\n" +
            "    name VARCHAR(255),\n" +
            "    PRIMARY KEY (id_group));";

    private final String users = "CREATE TABLE users(\n" +
            "    id_user INT AUTO_INCREMENT,\n" +
            "    user_group_id INT NOT NULL ,\n" +
            "    username VARCHAR(255),\n" +
            "    email VARCHAR(255),UNIQUE\n" +
            "    password VARCHAR(240),\n" +
            "    PRIMARY KEY (id_user),\n" +
            "    FOREIGN KEY (user_group_id) REFERENCES user_group(id_group)\n" +
            "                  ON DELETE CASCADE ON UPDATE CASCADE);";

    private final String solution = "CREATE TABLE solution(\n" +
            "    id_solution INT AUTO_INCREMENT,\n" +
            "    created DATETIME NOT NULL ,\n" +
            "    updated DATETIME NOT NULL ,\n" +
            "    description TEXT NOT NULL ,\n" +
            "    exercise_id INT NOT NULL ,\n" +
            "    user_id INT NOT NULL ,\n" +
            "    PRIMARY KEY (id_solution),\n" +
            "    FOREIGN KEY (exercise_id) REFERENCES exercise(id_exercise),\n" +
            "    FOREIGN KEY (user_id) REFERENCES users(id_user)\n" +
            "                     ON DELETE CASCADE ON UPDATE CASCADE );";
}
