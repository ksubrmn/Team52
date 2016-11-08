/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModelFacade {
    private static  ModelFacade instance = new ModelFacade();
    //private static int nextNum = 10;
    private List<User> users = new ArrayList<>();
    //private int selectedSourceReport = 0;
    //private int selectedPurityReport = 0;
    private int selectedUser = 0;

    public static ModelFacade getInstance() { return instance; }

    private ModelFacade() {
        //generateUniverse();
    }

    public void dumpData() {
        System.out.println("Dumping Data from Model");
        System.out.println("Selected User: " + selectedUser + " : " + users.get(selectedUser));
        System.out.println("User List:");
        users.forEach(u -> {System.out.println(u);});
    }

    public void addUser(String username, String password, AccountType type) {
        users.add(new User(username, password, type));
    }

    public void setSelectedPlanet(int n) {
        selectedUser = n;
    }


    public void saveModelText() {
        try {
            try (PrintWriter out = new PrintWriter(new File("data.text"))) {
                out.println(users.size());
                out.println(selectedUser);
                for (User p : users) {
                    p.saveTo(out);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadModelText()  {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("data.text"))) {
                int count = Integer.parseInt(br.readLine());
                selectedUser = Integer.parseInt(br.readLine());
                users = new ArrayList<>();
                for (int i = 0; i < count; ++i ) {
                    String line = br.readLine();
                    String[] tokens = line.split("\t");
                    users.add(new User(tokens[0], tokens[1], AccountType.valueOf(tokens[2])));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveModelBinary()  {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
                out.writeObject(users);
            }
        } catch (IOException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadModelBinary()  {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"))) {
                users = (List<User>) in.readObject();
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveModelJson() {
        try {
            try (PrintWriter out = new PrintWriter(new File("data.json"))) {
                Gson gs = new Gson();
                String gson = gs.toJson(this);
                out.println(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadModelJson() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("data.json"))) {
                String json = br.readLine();
                System.out.println(json);
                Gson gs = new Gson();
                instance = gs.fromJson(json, ModelFacade.class);
            }
        }catch (IOException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

/*    private void generateUniverse() {

    }*/

    public Iterable<User> getPlanets() {
        return users;
    }

    public User getSelectedPlanet() { return users.get(selectedUser); }

}
