package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class Results extends AppCompatActivity {
    private ArrayList<Integer> results = new ArrayList<>();
    private ArrayList<Restaurant> restaurants_list = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private String recommended;
    public static final int QUIZ_SIZE = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        final String room_code = intent.getStringExtra("room");
        results = getIntent().getIntegerArrayListExtra("results");
        ArrayList<String> tag = getIntent().getStringArrayListExtra("tags");
        create_restaurants(restaurants_list);

        ArrayList<Restaurant> intermediate = new ArrayList<>();
        ArrayList<Restaurant> intermediate2 = new ArrayList<>();
        ArrayList<Restaurant> intermediate3 = new ArrayList<>();
        ArrayList<Restaurant> intermediate4 = new ArrayList<>();
        ArrayList<Restaurant> intermediate5 = new ArrayList<>();
        ArrayList<Restaurant> intermediate6 = new ArrayList<>();
        ArrayList<String> tags;

        int flag = 0;

        for (int i = 0 ; i < QUIZ_SIZE; i ++){
            if (i == 0 ){
                if (results.get(i) == 1){
                    for (int j = 0; j <  restaurants_list.size(); j ++) {
                        tags = restaurants_list.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "cheap") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0)
                            intermediate.add(restaurants_list.get(j));
                        flag = 0;
                    }
                }
                else{
                    for (int j = 0; j <  restaurants_list.size(); j ++) {
                        tags = restaurants_list.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "cheap") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate.add(restaurants_list.get(j));
                        flag = 0;
                    }
                }
                if (intermediate.isEmpty()){
                    intermediate5 = restaurants_list;
                    break;
                }
            }
            if (i == 1){
                if (results.get(i) == 1){
                    for (int j = 0; j <  intermediate.size(); j ++) {
                        tags = intermediate.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "fast") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate2.add(intermediate.get(j));
                        flag = 0;
                    }
                }
                else{
                    for (int j = 0; j <  intermediate.size(); j ++) {
                        tags = intermediate.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "fast") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0)
                            intermediate2.add(intermediate.get(j));
                        flag = 0;
                    }
                }
                if (intermediate2.isEmpty()){
                    intermediate5 = intermediate;
                    break;
                }
            }
            if (i == 2){
                if (results.get(i) == 1){
                    for (int j = 0; j <  intermediate2.size(); j ++) {
                        tags = intermediate2.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "dinner") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate3.add(intermediate2.get(j));
                        flag = 0;
                    }
                }
                else{
                    for (int j = 0; j <  intermediate2.size(); j ++) {
                        tags = intermediate2.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == "breakfast" || tags.get(k) == "lunch") {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate3.add(intermediate2.get(j));
                        flag = 0;
                    }
                }
                if (intermediate3.isEmpty()){
                    intermediate5 = intermediate2;
                    break;
                }
            }
            else if (i > 2 && i < 5){
                if (results.get(i) == 1){
                    for (int j = 0; j <  intermediate3.size(); j ++) {
                        tags = intermediate3.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == tag.get(i)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate4.add(intermediate3.get(j));
                        flag = 0;
                    }
                }
                if (intermediate4.isEmpty()){
                    intermediate5 = intermediate3;
                    break;
                }
            }
            else{
                if (results.get(i) == 1){
                    for (int j = 0; j <  intermediate4.size(); j ++) {
                        tags = intermediate4.get(j).getTags();
                        for (int k = 0; k < tags.size(); k++) {
                            if (tags.get(k) == tag.get(i)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1)
                            intermediate5.add(intermediate4.get(j));
                        flag = 0;
                    }
                }
                if (intermediate5.isEmpty()){
                    intermediate5 = intermediate4;
                }
            }
        }
        /*if (intermediate.isEmpty())
            recommended = "empty1";
        else if (intermediate2.isEmpty())
            recommended = "empty2";
        else if (intermediate3.isEmpty())
            recommended = "empty3";
        else if (intermediate4.isEmpty())
            recommended = "empty4";
        else if (intermediate5.isEmpty())
            recommended = "empty5";
        else*/
        int rand_int;
        Random r = new Random();
        rand_int = r.nextInt(intermediate5.size());
            recommended = (intermediate5.get(rand_int).getRestaurantName());
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(recommended);


    }
    public void create_restaurants(ArrayList<Restaurant> restaurants){
        Restaurant mcdonalds = new Restaurant("McDonald's");
        mcdonalds.addTags("cheap");
        mcdonalds.addTags("fast");
        mcdonalds.addTags("dinner");
        mcdonalds.addTags("lunch");
        mcdonalds.addTags("breakfast");
        mcdonalds.addTags("western");
        mcdonalds.addTags("dessert");
        restaurants.add(mcdonalds);

        Restaurant fritz = new Restaurant("Fritz European Fry House");
        fritz.addTags("cheap");
        fritz.addTags("fast");
        fritz.addTags("lunch");
        fritz.addTags("western");
        restaurants.add(fritz);

        Restaurant wendy = new Restaurant("Wendy's");
        wendy.addTags("cheap");
        wendy.addTags("fast");
        wendy.addTags("dinner");
        wendy.addTags("lunch");
        wendy.addTags("western");
        restaurants.add(wendy);

        Restaurant aw = new Restaurant("A&W");
        aw.addTags("cheap");
        aw.addTags("fast");
        aw.addTags("dinner");
        aw.addTags("lunch");
        aw.addTags("breakfast");
        aw.addTags("western");
        restaurants.add(aw);

        Restaurant passion = new Restaurant("Passion8 Dessert Cafe");
        passion.addTags("asian");
        passion.addTags("dessert");
        passion.addTags("sit");
        restaurants.add(passion);

        Restaurant crackle = new Restaurant("Crackle Creme");
        crackle.addTags("cheap");
        crackle.addTags("dessert");
        restaurants.add(crackle);

        Restaurant mosquito = new Restaurant("Mosquito");
        mosquito.addTags("dessert");
        mosquito.addTags("sit");
        restaurants.add(mosquito);

        Restaurant acme = new Restaurant("Acme Cafe");
        acme.addTags("lunch");
        acme.addTags("western");
        acme.addTags("sit");
        restaurants.add(acme);

        Restaurant fish = new Restaurant("The Fish Counter");
        fish.addTags("cheap");
        fish.addTags("lunch");
        fish.addTags("western");
        fish.addTags("sit");
        restaurants.add(fish);

        Restaurant east = new Restaurant("East is East");
        east.addTags("cheap");
        east.addTags("dinner");
        east.addTags("lunch");
        east.addTags("middle");
        east.addTags("vegetarian");
        east.addTags("sit");
        restaurants.add(east);

        Restaurant jamjar = new Restaurant("Jamjar Folk Lebanese Food");
        jamjar.addTags("cheap");
        jamjar.addTags("dinner");
        jamjar.addTags("lunch");
        jamjar.addTags("middle");
        jamjar.addTags("vegetarian");
        restaurants.add(jamjar);

        Restaurant basha = new Restaurant("Al Basha");
        basha.addTags("cheap");
        basha.addTags("dinner");
        basha.addTags("lunch");
        basha.addTags("middle");
        restaurants.add(basha);

        Restaurant chili = new Restaurant("The Chili House");
        chili.addTags("cheap");
        chili.addTags("lunch");
        chili.addTags("asian");
        chili.addTags("spicy");
        chili.addTags("sit");
        restaurants.add(chili);

        Restaurant joojak = new Restaurant("Joojak Restaurant");
        joojak.addTags("dinner");
        joojak.addTags("lunch");
        joojak.addTags("asian");
        joojak.addTags("spicy");
        joojak.addTags("sit");
        restaurants.add(joojak);

        Restaurant ajisai = new Restaurant("Ajisai Sushi Bar");
        ajisai.addTags("dinner");
        ajisai.addTags("lunch");
        ajisai.addTags("asian");
        ajisai.addTags("sit");
        restaurants.add(ajisai);

        Restaurant jam = new Restaurant("Jam Cafe on Beatty");
        jam.addTags("breakfast");
        jam.addTags("western");
        jam.addTags("sit");
        restaurants.add(jam);

        Restaurant medina = new Restaurant("Medina Cafe");
        medina.addTags("breakfast");
        medina.addTags("middle");
        medina.addTags("sit");
        restaurants.add(medina);

        Restaurant marulilu = new Restaurant("Marulilu Cafe");
        marulilu.addTags("cheap");
        marulilu.addTags("lunch");
        marulilu.addTags("breakfast");
        marulilu.addTags("asian");
        marulilu.addTags("sit");
        restaurants.add(marulilu);

        Restaurant acorn = new Restaurant("The Acorn");
        acorn.addTags("lunch");
        acorn.addTags("vegetarian");
        restaurants.add(acorn);

        Restaurant bandidas = new Restaurant("Bandidas Taqueria");
        bandidas.addTags("cheap");
        bandidas.addTags("lunch");
        bandidas.addTags("breakfast");
        bandidas.addTags("western");
        bandidas.addTags("vegetarian");
        bandidas.addTags("spicy");
        restaurants.add(bandidas);

        Restaurant mexican = new Restaurant("The Mexican Antojitos Y Cantina");
        mexican.addTags("cheap");
        mexican.addTags("dinner");
        mexican.addTags("lunch");
        mexican.addTags("western");
        mexican.addTags("spicy");
        mexican.addTags("sit");
        restaurants.add(mexican);

        Restaurant kobob = new Restaurant("Kobob Burger");
        kobob.addTags("cheap");
        kobob.addTags("dinner");
        kobob.addTags("lunch");
        kobob.addTags("asian");
        restaurants.add(kobob);

        Restaurant rain = new Restaurant("Rain or Shine Ice Cream");
        rain.addTags("cheap");
        rain.addTags("dessert");
        restaurants.add(rain);

        Restaurant tangram = new Restaurant("Tangram Creamery");
        tangram.addTags("cheap");
        tangram.addTags("dessert");
        restaurants.add(tangram);

        Restaurant yek = new Restaurant("Yek O Yek");
        yek.addTags("cheap");
        yek.addTags("middle");
        yek.addTags("dessert");
        restaurants.add(yek);

        Restaurant five = new Restaurant("Five Guys");
        five.addTags("cheap");
        five.addTags("fast");
        five.addTags("dinner");
        five.addTags("lunch");
        five.addTags("western");
        restaurants.add(five);

        Restaurant kyo = new Restaurant("Kyo Korean BBQ & Sushi House");
        kyo.addTags("dinner");
        kyo.addTags("lunch");
        kyo.addTags("asian");
        kyo.addTags("sit");
        restaurants.add(kyo);

        Restaurant gyu = new Restaurant("Gyu-Kaku Japanese BBQ");
        gyu.addTags("dinner");
        gyu.addTags("lunch");
        gyu.addTags("asian");
        gyu.addTags("sit");
        restaurants.add(gyu);

        Restaurant kurumucho = new Restaurant("Kurumucho Japanese Taco Shop");
        kurumucho.addTags("lunch");
        kurumucho.addTags("asian");
        kurumucho.addTags("vegetarian");
        restaurants.add(kurumucho);
    }
}
