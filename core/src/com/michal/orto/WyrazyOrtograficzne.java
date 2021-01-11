package com.michal.orto;

public class WyrazyOrtograficzne {


    public String poczatekWyrazu(int x){                                                /*10*/                                              /*20*/                                                             /*30*/                                                     /*40*/                                                   /*50*/
        String[] poczatekWyrazu = {"Gr", "Dm", "", "samo", "dru", "dop", "", "", "sk", "pró", "", "s", "k", "bu", "", "", "po", "ko", "wy", "wró", "ko", "pejza", "zde", "no", "stró", "pisko", "p", "", "war", "w", "l", "k", "t", "k", "p", "ub", "potw", "wsp", "wkr", "pr", "b", "tch", "", "", "ob", "pu", "anar", "wa", "", "szla", "alko", "o", "ma", "in", "gra", "", "", "", ""};
        String wyraz=poczatekWyrazu[x];
        return wyraz;
    }
    public String srodekWyrazu(int x){                                        /*10*/                                                 /*20*/                                                  /*30*/                                            /*40*/                                                   /*50*/
        String[] srodekWyrazu = {"ó", "u", "ż", "ch", "h", "ó", "ż", "ó", "u", "ż", "rz", "ch", "u", "rz", "rz", "rz", "rz", "ż", "ż", "ż", "ż", "rz", "rz", "ż", "ż", "rz", "rz", "rz", "u", "u", "u", "u", "u", "u", "u", "ó", "ó", "ó", "ó", "ó", "ó", "ó", "ch", "ch", "ch", "ch", "ch", "ch", "ch", "ch", "h", "h", "h", "h", "h", "h", "h", "h", "h"};
        String wyraz=srodekWyrazu[x];
        return wyraz;
    }
    public String koniecWyrazu(int x){                                                                  /*10*/                                                                                 /*20*/                                                            /*30*/                                                                 /*40*/                                                               /*50*/
        String[] koniecWyrazu = {"d", "chawiec", "ubr", "ód", "na", "ki", "yrandol", "wczesny", "wka", "nowac", "odkiewka", "emat", "rz", "a", "adki", "epa", "eczka", "uch", "ynac", "ba", "ystac", "", "ak", "yczki", "", "", "odek", "emien", "nek", "jek", "ksus", "rek", "rban", "la", "la", "stwo", "r", "lnota", "tce", "szy", "br", "rz", "ytry", "aos", "ody", "ar", "ia", "larz", "oinka", "ta", "ol", "ydny", "oniowy", "alacja", "amka", "oryzont", "igiena", "arcerz", "onor"};
        String wyraz=koniecWyrazu[x];
        return wyraz;
    }
}
