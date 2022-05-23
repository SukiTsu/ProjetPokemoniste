package vue;

import ComposantGraphique.Box.*;
import ComposantGraphique.Scroll.ScrollPaneVille;
import ComposantGraphique.Scroll.ScrollPaneCli;
import Controler.Controler;
import javafx.scene.layout.VBox;
import modele.*;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Calcule.Calcul.doChemin;
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
    static VBoxChemin vBoxChemin = new VBoxChemin();
    static VBoxTroisChemins vBoxTroisChemins = new VBoxTroisChemins();

    MenuBarChoixUtilisateur boxMenu = new MenuBarChoixUtilisateur();

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
        vBoxChemin.setAllChemin(dicVille.getListChemin());
        vBoxTroisChemins.setBoxAll();


        scrollPaneVille.setScollVille();
        srollPaneCli.setScoll(boxScenario.getScenarioList().get(0));
        boxRegroup.add(boxScenario.getBox());
        boxRegroup.add(srollPaneCli.getBoxAll());
        boxRegroup.add(scrollPaneVille.getBoxAll());

        this.getChildren().add(boxMenu.getMenuBar());
        this.getChildren().add(boxRegroup.getBox());
        //this.getChildren().add(vBoxChemin.getBoxAll());
        this.getChildren().add(vBoxTroisChemins.getBoxAll());
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
    public static VBoxTroisChemins getvBoxTroisChemins(){
        return vBoxTroisChemins;
    }


}
