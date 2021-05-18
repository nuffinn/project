package aims_gui;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
//	ArrayList<Order> orderList = new ArrayList<>();
	int index = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("AIMS application");
			
			VBox root = new VBox();
			FlowPane flPane = new FlowPane();
			
			MenuBar menu = new MenuBar();
			Menu menuOrder = new Menu("Order");
			Menu menuItem = new Menu("Item");
			MenuItem newOrder = new MenuItem("New order");
			MenuItem displayOrder = new MenuItem("DisplayOrder");
			MenuItem addItem = new MenuItem("Add item");
			MenuItem deleteItem = new MenuItem("Delete item");
			
			menuOrder.getItems().addAll(newOrder, displayOrder);
			menuItem.getItems().addAll(addItem, deleteItem);
			menu.getMenus().addAll(menuOrder, menuItem);
			
//			ObservableList<Order> orders = FXCollections.observableArrayList(orderList);
			ChoiceBox<Order> choiceBox = new ChoiceBox<Order>();
			Label lbl = new Label("Select order:");
			flPane.getChildren().addAll(lbl, choiceBox);
			flPane.setHgap(20);
			
			StackPane stack = new StackPane();
			
			//delete Panel
			FlowPane dlPane = new FlowPane();
			dlPane.setHgap(20);
			Label dlLabel = new Label("Remove by ID");
			TextField tfDelete = new TextField();
			Button btnRemove = new Button("Remove");
			btnRemove.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					int id1 = Integer.parseInt(tfDelete.getText());
					choiceBox.getSelectionModel().getSelectedItem().removeById(id1);
					
				}
				
			});
			dlPane.getChildren().addAll(dlLabel, tfDelete, btnRemove);
			dlPane.setVisible(false);
			stack.getChildren().add(dlPane);
			
			//add item panel
			VBox vb1 = new VBox();
			FlowPane fl1 = new FlowPane();
			FlowPane fl2 = new FlowPane();
			Label addPnl = new Label("Add item:");
			Label addPn2 = new Label("Title: ");
			Label addPn3 = new Label("Id: ");
			TextField tf2 = new TextField();
			TextField tf3 = new TextField();
			Button addbtn = new Button("Add");
			fl1.getChildren().addAll(addPn2, tf2);
			fl2.getChildren().addAll(addPn3, tf3);
			vb1.getChildren().addAll(addPnl, fl1, fl2, addbtn);
			vb1.setVisible(false);
			stack.getChildren().add(vb1);
			
			root.getChildren().addAll(menu, flPane, stack);
			
			newOrder.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
//					orderList.add(new Order("Order" + index, index));
					choiceBox.getItems().add(new Order("Order"+index, index));
					index++;
				}

			});
			
			addItem.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					dlPane.setVisible(false);
					vb1.setVisible(true);
				}
				
			});
			
			deleteItem.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					vb1.setVisible(false);
					dlPane.setVisible(true);	
				}
				
			});
			
			Scene scene = new Scene(root,500,500);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

