package models;

import java.util.ArrayList;

import etu1888.annotation.Anno_Url;
import etu1888.framework.ModelView;

public class Emp {
    String nom;
     
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Anno_Url(url = "/Emp/findall")
    public ModelView findall() {
        ModelView view  = new ModelView();
        view.setView("/emp-findall.jsp");
        ArrayList<String> employees = new ArrayList<String>();
        employees.add("Tahiry");
        employees.add("Ny Aina");
        employees.add("LogiKT");
        view.addItem("list-emp", employees);
        return view;
    }

    @Anno_Url(url = "/Emp/insert")
    public ModelView insert(){
        ModelView view = new ModelView("/emp-insert.jsp");
        return view;
    }

    public void test(){
        
    }
}