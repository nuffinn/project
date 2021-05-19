package aims_gui;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
//	ArrayList<Order> orderList = new ArrayList<>();
	int index = 0;
	private int temp = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("AIMS application");
			
			VBox root = new VBox();
			root.setSpacing(8);
			FlowPane flPane = new FlowPane();
			
			MenuBar menu = new MenuBar();
			Menu menuOrder = new Menu("Order");
			Menu menuItem = new Menu("Item");
			MenuItem newOrder = new MenuItem("New order");
			MenuItem displayOrder = new MenuItem("DisplayOrder");
			MenuItem addItem = new MenuItem("Add item");
			MenuItem deleteItem = new MenuItem("Delete item");
			TextArea txtArea = new TextArea("Display order: \n");
			txtArea.setVisible(false);
			
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
					txtArea.clear();
				}
				
			});
			dlPane.getChildren().addAll(dlLabel, tfDelete, btnRemove);
			dlPane.setVisible(false);
			stack.getChildren().add(dlPane);
			
			//add item panel
			VBox vb1 = new VBox();
			HBox hb1 = new HBox();
			HBox hb2 = new HBox();
			FlowPane fl1 = new FlowPane();
			FlowPane fl2 = new FlowPane();
			Label addPnl = new Label("Add item:");
			Label addPn2 = new Label("Title: ");
			Label addPn3 = new Label("Id:     ");
			Label addPn4 = new Label("Media : ");
			TextField tf2 = new TextField();
			TextField tf3 = new TextField();
			Button addbtn = new Button("Add");
			Button playbtn = new Button("Play");
			playbtn.setVisible(false);
			ToggleGroup group = new ToggleGroup();
			
			addbtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (temp == 1) {
						choiceBox.getSelectionModel().getSelectedItem().addBook(new Book(tf2.getText(), Integer.parseInt(tf3.getText())));
					}
					if (temp == 2) {
						choiceBox.getSelectionModel().getSelectedItem().addDVD(new DigitalVideoDisc(tf2.getText(), Integer.parseInt(tf3.getText())));
						playbtn.setVisible(true);
					}
					if (temp ==3) {
						choiceBox.getSelectionModel().getSelectedItem().addCD(new CompactDisc(tf2.getText(), Integer.parseInt(tf3.getText())));
						playbtn.setVisible(true);
					}
					
					tf2.clear();
					tf3.clear();
					
				}
				
			});
			
			playbtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Playing " + tf2.getText());
					alert.setHeaderText(null);
					alert.setContentText(tf2.getText() + " played successfully!");
					alert.show();
				}
			});
			
//			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//		           @Override
//		           public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle newT) {
//		               // Has selection.
//		               if (group.getSelectedToggle() != null) {
//		                   
//		               }
//		           }
//		       });
			
			RadioButton book = new RadioButton("Book");
			book.setToggleGroup(group);
			book.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					temp = 1;
				}
				
			});
			
			RadioButton dvd = new RadioButton("DVD");
			dvd.setToggleGroup(group);
			dvd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					temp = 2;
				}
				
			});
			
			RadioButton cd = new RadioButton("CD");
			cd.setToggleGroup(group);
			cd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					temp = 3;
				}
				
			});
			
			hb1.getChildren().addAll(addPn4, book, dvd, cd);
			hb1.setSpacing(20);
			
			hb2.getChildren().addAll(addbtn, playbtn);
			hb2.setSpacing(10);
			
			fl1.getChildren().addAll(addPn2, tf2);
			fl2.getChildren().addAll(addPn3, tf3);
			vb1.getChildren().addAll(addPnl, hb1, fl1, fl2, hb2); 
			vb1.setVisible(false);
			stack.getChildren().add(vb1);
			root.getChildren().addAll(menu, flPane, stack, txtArea);
			
			
			
			//menu action
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
			
			displayOrder.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					txtArea.clear();
					txtArea.setVisible(true);
					Order tmp = choiceBox.getSelectionModel().getSelectedItem();
					for (int i=0; i<tmp.getNbOrdered(); i++) {
						int x = i+1;
						txtArea.appendText(x +". title :" + tmp.get(i).getTitle() + " id: " + tmp.get(i).getId() + "\n");
					}
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

