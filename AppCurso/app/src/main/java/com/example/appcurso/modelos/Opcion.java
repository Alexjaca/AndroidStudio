package com.example.appcurso.modelos;

public class Opcion {
    private String mText;
    private int mNextpage;

    public Opcion(String Text, int Nextpage) {
        this.mText = Text;
        this.mNextpage = Nextpage;
    }

    public String getText() {
        return mText;
    }

    public void setmText(String Text) {
        this.mText = Text;
    }

    public int getNextpage() {
        return mNextpage;
    }

    public void setmNextpage(int Nextpage) {
        this.mNextpage = Nextpage;
    }
}
