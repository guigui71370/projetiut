package com.example.cassa.entrainementprojettut.histoire.model;


import com.example.cassa.entrainementprojettut.histoire.theme.Dates;

import java.util.ArrayList;
import java.util.List;

public class lvl2  implements I_lvl{
    @Override
    public List<String[]> getReponce() {
        Dates[] values = Dates.values();

        ArrayList<String[]> arrayList=new ArrayList<>();
        while(arrayList.size()<4){
            int index= (int) (Math.random()*values.length);
            if(existe(arrayList,values[index].getquestion())){
                arrayList.add(new String[]{values[index].getquestion(),values[index].getreponce(),values[index].gettheme()});
            }

        }
       return arrayList;
    }

    private boolean existe(ArrayList<String[]> list,String test){

        int i=0;
        while (i<list.size() && !test.equals(list.get(i)[0])){
            i++;
        }
        return i==list.size();
    }
}
