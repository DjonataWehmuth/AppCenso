package com.example.djonata.appcenso.Modelo;

import java.io.Serializable;

/**
 * Created by Djonata on 25/11/2016.
 */

public class Censo implements Serializable{
    private int id;
    private String endereco;
    private int homens;
    private int mulheres;
    private int criancas;

    public int getID(){return id;}
    public int getHomens(){return homens;}
    public int getMulheres(){return mulheres;}
    public int getCriancas(){return criancas;}
    public String getEndereco(){return endereco;}

    public void setId(int id){this.id = id;}
    public void setHomens (int homens){this.homens = homens;}
    public void setMulheres(int mulheres){this.mulheres = mulheres;}
    public void setEndereco(String endereco){this.endereco = endereco;}
    public void setCriancas(int criancas){this.criancas = criancas;}
}
