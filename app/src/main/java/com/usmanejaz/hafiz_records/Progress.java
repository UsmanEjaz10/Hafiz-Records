package com.usmanejaz.hafiz_records;

public class Progress {

    public int id;
    public int starting_sabaq;
    public int ending_sabaq;
    public int para_sabaq;
    public int sabqi;
    public int manzil;



    public Progress(int id, int starting_sabaq, int ending_sabaq, int para_sabaq ,int sabqi, int manzil){
        this.id = id;
        this.starting_sabaq = starting_sabaq;
        this.ending_sabaq = ending_sabaq;
        this.para_sabaq = para_sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }
}
