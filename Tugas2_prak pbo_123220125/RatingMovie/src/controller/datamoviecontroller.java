/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import model.*;
import View.MainView;
/**
 *
 * @author LENOVO LEGION
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> dm;
    
    public datamoviecontroller(MainView frame){
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        dm = impldatamovie.getAll();
    }
    
    public void isitabel(){
        dm = impldatamovie.getAll();
        modeltabeldatamovie mp = new modeltabeldatamovie(dm);
        frame.getTabelDatamovie().setModel(mp);
    }
    
    public void insert(){
        datamovie dm = new datamovie();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setAlur(Double.parseDouble(frame.getJtxtalur().getText())); // Konversi ke Double
        dm.setPenokohan(Double.parseDouble(frame.getJtxtpenokohan().getText())); // Konversi ke Double
        dm.setAkting(Double.parseDouble(frame.getJtxtakting().getText()));
        dm.calculateNilai(); // Menghitung nilai berdasarkan atribut yang sudah diatur
        impldatamovie.insert(dm);
    }
    
    public void update(){
        datamovie dm = new datamovie();
        dm.setAlur(Double.parseDouble(frame.getJtxtalur().getText())); // Konversi ke Double
        dm.setPenokohan(Double.parseDouble(frame.getJtxtpenokohan().getText())); // Konversi ke Double
        dm.setAkting(Double.parseDouble(frame.getJtxtakting().getText()));
        dm.calculateNilai(); // Menghitung nilai berdasarkan atribut yang sudah diatur
        dm.setJudul(frame.getJTxtjudul().getText());
        impldatamovie.update(dm);
    }
    
    public void delete(){
        String judul = frame.getJTxtjudul().getText();
        impldatamovie.delete(judul);
    }
}

