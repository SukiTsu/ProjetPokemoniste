package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;

import static ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin.gethBoxList;

public class VBoxPremierChemin {

    VBox boxAll;
    VBox box;
    ScrollPane scrollPane;

    public VBoxPremierChemin(){
        boxAll = new VBox();
        box = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setContent(box);
        boxAll.getChildren().add(scrollPane);
    }

    public void setBox(){
        boxAll.getChildren().remove(0);
        scrollPane = new ScrollPane();
        scrollPane.setContent(box);

        Label labelTitle = new Label("Chemin 0");
        labelTitle.setId("labelCheminEtape");
        box.getChildren().add(labelTitle);
        for (String ville : VBoxRoot.getDicVille().getPremierList().get(0)){
            box.getChildren().add(new Label(ville));
        }
        box.getChildren().get(box.getChildren().size()-1).setId("labelDISTANCE");
        //box.getChildren().add(gethBoxList().get(0).getChildren().get(0));
        System.out.println("taille" + gethBoxList().get(0).getChildren().size());
        boxAll.getChildren().add(scrollPane);
    }

    public VBox getBox(){
        return boxAll;
    }
}
