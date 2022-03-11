import controller.TableController;
import model.TableReceiptModel;
import view.MainView;

class Main {
    public static void main( String[] args) throws Exception {
        TableReceiptModel tableReceiptModel = new TableReceiptModel();
        MainView mainView = new MainView(tableReceiptModel);
        new TableController(tableReceiptModel, mainView);
        mainView.setVisible(true);

    }
}
