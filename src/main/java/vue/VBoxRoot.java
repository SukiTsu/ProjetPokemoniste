package vue;

import ComposantGraphique.Box.*;
import ComposantGraphique.Box.BoxAfficheChemin.GridPaneChoixAfficheChemin;
import ComposantGraphique.Box.BoxAfficheChemin.StackPaneAfficheChemin;
import ComposantGraphique.Box.BoxAfficheChemin.VBoxChemin;
import ComposantGraphique.Box.BoxAfficheChemin.VBoxTroisChemins;
import ComposantGraphique.Scroll.ScrollPaneVille;
import ComposantGraphique.Scroll.ScrollPaneCli;
import Controler.Controler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.*;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static modele.LectureEcriture.lectureScenario;
import static modele.VariableLoc.getListVilleAch;
import static modele.VariableLoc.getListVilleVend;

public class VBoxRoot extends VBox {


    static ScrollPaneVille scrollPaneVille = new ScrollPaneVille();
    static ScrollPaneCli srollPaneCli = new ScrollPaneCli();
    static BoxScenario boxScenario = new BoxScenario();
    static Controler controler = new Controler();
    static BoxRegroup boxRegroup = new BoxRegroup();
    static VariableLoc variableLoc = new VariableLoc();
    static DicVille dicVille = new DicVille();
    static StackPaneAfficheChemin stackPaneAfficheChemin = new StackPaneAfficheChemin();
    static MenuBarChoixUtilisateur boxMenu = new MenuBarChoixUtilisateur();
    static GridPaneChoixAfficheChemin gridPaneChoixAfficheChemin = new GridPaneChoixAfficheChemin();
    static HBox box_boxMenu_stackPane = new HBox();


    public VBoxRoot() throws IOException {
        File[] fichierScenario = new File("src/main/java/fichier_txt").listFiles();
        for (File fichier : fichierScenario){
            Scenario scenario = lectureScenario(fichier);

            boxScenario.addScenario(scenario);
        }

        variableLoc.setVariable(boxScenario.getScenarioList().get(0));
        dicVille.setDicVille(getListVilleVend(), getListVilleAch());
        dicVille.doChemin(dicVille.getDicVille(), new ArrayList<>());
        //System.out.println(dicVille.getListChemin());
        //vBoxChemin.setAllChemin(dicVille.getListChemin());
        //vBoxTroisChemins.setBoxAll();
        stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
        box_boxMenu_stackPane.getChildren().addAll(gridPaneChoixAfficheChemin.getGridPane(),stackPaneAfficheChemin.getStackPane());


        scrollPaneVille.setScollVille();
        srollPaneCli.setScoll(boxScenario.getScenarioList().get(0));
        boxRegroup.add(boxScenario.getBox());
        boxRegroup.add(srollPaneCli.getBoxAll());
        boxRegroup.add(scrollPaneVille.getBoxAll());

        this.getChildren().add(boxMenu.getMenuBar());
        this.getChildren().add(boxRegroup.getBox());
        this.getChildren().add(box_boxMenu_stackPane);
        //this.getChildren().add(vBoxChemin.getBoxAll());
        //this.getChildren().add(vBoxTroisChemins.getBoxAll());
        //this.getChildren().add(gridPaneChoixAfficheChemin.getGridPane());
    }

    public static ScrollPaneVille getScrollPaneVille(){
        return scrollPaneVille;
    }
    public static ScrollPaneCli getSrollPaneCli(){
        return srollPaneCli;
    }
    public static BoxScenario getBoxScenario(){
        return boxScenario;
    }
    public static Controler getControler(){
        return controler;
    }
    public static VariableLoc getVariableLoc(){
        return variableLoc;
    }
    public static DicVille getDicVille(){
        return dicVille;
    }
    public static HBox getBox_boxMenu_stackPane(){
        return box_boxMenu_stackPane;
    }



}
