package com.example.appcurso.modelos;

public class Pagina {
    private int mImageid;
    private String mNombre;
    private Opcion mOpcion1;
    private Opcion mOpcion2;
    private boolean mIsFinal = false;

    public Pagina(int Imageid, String Nombre, Opcion Opcion1, Opcion Opcion2) {
        this.mImageid = Imageid;
        this.mNombre = Nombre;
        this.mOpcion1 = Opcion1;
        this.mOpcion2 = Opcion2;
    }

    public Pagina(int Imageid, String Nombre) {
        this.mImageid = Imageid;
        this.mNombre = Nombre;
        this.mOpcion1 = null;
        this.mOpcion2 = null;
        mIsFinal = true;
    }

    public boolean isFinal (){
        return  mIsFinal;
    }
    public void setIsFinal(boolean isFinal){
        mIsFinal = isFinal;
    }

    public int getImageid() {
        return mImageid;
    }

    public void setImageid(int Imageid) {
        this.mImageid = Imageid;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String Nombre) {
        this.mNombre = Nombre;
    }

    public Opcion getOpcion1() {
        return mOpcion1;
    }

    public void setOpcion1(Opcion Opcion1) {
        this.mOpcion1 = Opcion1;
    }

    public Opcion getOpcion2() {
        return mOpcion2;
    }

    public void setOpcion2(Opcion Opcion2) {
        this.mOpcion2 = Opcion2;
    }
}
