package com.example.cassa.entrainementprojettut.astronomie;

import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageFactoriesSize {

    public  static void factorisize(ImageView d,String name,float density){

            if(name.equals("mercure")) {

                d.getLayoutParams().height = (int) (50*density);
                d.getLayoutParams().width=(int) (50*density);

            }else if(name.equals("venus")){
                d.getLayoutParams().height = (int) (70*density);
                d.getLayoutParams().width=(int) (70*density);

            }
            else if(name.equals("terre")){


                d.getLayoutParams().height =(int) (80*density);
                d.getLayoutParams().width=(int) (80*density);



            } else if(name.equals("mars")){


                d.getLayoutParams().height =(int) (60*density);
                d.getLayoutParams().width=(int) (60*density);



            }else if(name.equals("jupiter")){


                d.getLayoutParams().height =(int) (200*density);
                d.getLayoutParams().width=(int) (200*density);



            }else if(name.equals("saturne")){


                d.getLayoutParams().height =(int) (150*density);
                d.getLayoutParams().width=(int) (150*density);



            }else if(name.equals("uranus")){


                d.getLayoutParams().height =(int) (100*density);
                d.getLayoutParams().width=(int) (100*density);



            }else if(name.equals("neptune")){


                d.getLayoutParams().height =(int) (100*density);
                d.getLayoutParams().width=(int) (100*density);



            }







        d.requestLayout();




    }
}
