package model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleLongProperty Pid;
    private SimpleStringProperty CPU, User, StartInstant, Cmd;

    public Item(Long Pid, String CPU, String User, String StartInstant, String Cmd){
        this.Pid = new SimpleLongProperty(Pid);
        this.CPU = new SimpleStringProperty(CPU);
        this.User = new SimpleStringProperty(User);
        this.StartInstant = new SimpleStringProperty(StartInstant);
        this.Cmd = new SimpleStringProperty(Cmd);
    }

    public Long getPid(){
        return this.Pid.get();
    }

    public void setPid(Long Pid) {
        this.Pid.set(Pid);
    }

    public String getCPU(){
        return this.CPU.get();
    }

    public void setCPU(String CPU) {
        this.CPU.set(CPU);
    }

    public String getUser(){
        return this.User.get();
    }

    public void setUser(String User) {
        this.User.set(User);
    }

    public String getStartInstant(){
        return this.StartInstant.get();
    }

    public void setStartInstant(String StartInstant) {
        this.StartInstant.set(StartInstant);
    }

    public String getCmd(){
        return this.Cmd.get();
    }

    public void setCmd(String Cmd){
        this.Cmd.set(Cmd);
    }
}
