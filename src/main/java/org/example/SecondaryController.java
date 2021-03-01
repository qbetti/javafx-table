package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SecondaryController {

    @FXML public TableView<UserProperty> userTableView;
    @FXML public TableColumn<UserProperty, Integer> idColumn;
    @FXML public TableColumn<UserProperty, String> nameColumn;
    @FXML public TableColumn<UserProperty, String> createdByColumn;
    @FXML public TableColumn<UserProperty, Date> createdDateColumn;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName("Giovanni Giorgio "+i);
            user.setCreatedBy("Quentin "+i);
            user.setCreatedDate(LocalDate.now());
            userList.add(user);
        }

        List<UserProperty> userProperties = userList.stream()
                .map(UserProperty::new)
                .collect(Collectors.toList());


        ObservableList<UserProperty> members = FXCollections.observableArrayList(userProperties);
        userTableView.setItems(members);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        createdByColumn.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
        createdDateColumn.setCellValueFactory(new PropertyValueFactory<>("createdDate"));

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> userList.get(2).setName("Changé CHEH"),
                5000, TimeUnit.MILLISECONDS);

        service.schedule(
                () -> {
                    userList.get(3).setCreatedDate(LocalDate.of( 2011 , Month.JULY , 3 )
                            .minusWeeks(1));
                    System.out.println("yo");
                },
                6000, TimeUnit.MILLISECONDS);
    }
}