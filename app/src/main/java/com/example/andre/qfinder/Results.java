package com.example.andre.qfinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


public class Results extends AppCompatActivity {
    private ArrayList<Integer> results = new ArrayList<>();
    private ArrayList<Restaurant> restaurants_list = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private String recommended;
    public static final int QUIZ_SIZE = 7;
    private int rand_int;
    private ArrayList<Restaurant> intermediate = new ArrayList<>();
    private ArrayList<Restaurant> intermediate2 = new ArrayList<>();
    private ArrayList<Restaurant> intermediate3 = new ArrayList<>();
    private ArrayList<Restaurant> intermediate4 = new ArrayList<>();
    private ArrayList<Restaurant> intermediate5 = new ArrayList<>();
    private ArrayList<Restaurant> intermediate6 = new ArrayList<>();
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        final String room_code = intent.getStringExtra("room");
        results = getIntent().getIntegerArrayListExtra("results");
        ArrayList<String> tag = getIntent().getStringArrayListExtra("tags");
        create_restaurants(restaurants_list);


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
        Random r = new Random();
        rand_int = r.nextInt(intermediate5.size());
            recommended = (intermediate5.get(rand_int).getRestaurantName());
        URL restaurantURL = intermediate5.get(rand_int).getUrl();
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(recommended);


    }

    public void openYelp(View view) {
        // Do something in response to button
        //Intent intent = new Intent(this, EnterRoomActivity.class);

        String restaurantURL = intermediate5.get(rand_int).getStringURL();

        Uri uri = Uri.parse(restaurantURL); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void restartQuiz(View view){
        Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();
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
        mcdonalds.setUrl("https://www.yelp.com/biz/mcdonalds-vancouver-49");
        restaurants.add(mcdonalds);

        Restaurant fritz = new Restaurant("Fritz European Fry House");
        fritz.addTags("cheap");
        fritz.addTags("fast");
        fritz.addTags("lunch");
        fritz.addTags("western");
        fritz.setUrl("https://www.yelp.com/biz/fritz-european-fry-house-vancouver?osq=Fast+Food");
        restaurants.add(fritz);

        Restaurant wendy = new Restaurant("Wendy's");
        wendy.addTags("cheap");
        wendy.addTags("fast");
        wendy.addTags("dinner");
        wendy.addTags("lunch");
        wendy.addTags("western");
        wendy.setUrl("https://www.yelp.com/biz/wendys-vancouver-14?osq=Fast+Food");
        restaurants.add(wendy);

        Restaurant aw = new Restaurant("A&W");
        aw.addTags("cheap");
        aw.addTags("fast");
        aw.addTags("dinner");
        aw.addTags("lunch");
        aw.addTags("breakfast");
        aw.addTags("western");
        aw.setUrl("https://www.yelp.com/biz/a-and-w-vancouver-17?osq=Fast+Food");
        restaurants.add(aw);

        Restaurant passion = new Restaurant("Passion8 Dessert Cafe");
        passion.addTags("asian");
        passion.addTags("dessert");
        passion.addTags("sit");
        passion.setUrl("https://www.yelp.com/biz/passion8-dessert-cafe-vancouver?osq=Desserts");
        restaurants.add(passion);

        Restaurant crackle = new Restaurant("Crackle Creme");
        crackle.addTags("cheap");
        crackle.addTags("dessert");
        crackle.setUrl("https://www.yelp.com/biz/crackle-creme-vancouver-2?osq=Desserts");
        restaurants.add(crackle);

        Restaurant mosquito = new Restaurant("Mosquito");
        mosquito.addTags("dessert");
        mosquito.addTags("sit");
        mosquito.setUrl("https://www.yelp.com/biz/mosquito-vancouver?osq=Desserts");
        restaurants.add(mosquito);

        Restaurant acme = new Restaurant("Acme Cafe");
        acme.addTags("lunch");
        acme.addTags("western");
        acme.addTags("sit");
        acme.setUrl("https://www.yelp.com/biz/acme-cafe-vancouver-5?osq=Sit+Down+Lunch");
        restaurants.add(acme);

        Restaurant fish = new Restaurant("The Fish Counter");
        fish.addTags("cheap");
        fish.addTags("lunch");
        fish.addTags("western");
        fish.addTags("sit");
        fish.setUrl("https://www.yelp.com/biz/the-fish-counter-vancouver?osq=Sit+Down+Lunch");
        restaurants.add(fish);

        Restaurant east = new Restaurant("East is East");
        east.addTags("cheap");
        east.addTags("dinner");
        east.addTags("lunch");
        east.addTags("middle");
        east.addTags("vegetarian");
        east.addTags("sit");
        east.setUrl("https://www.yelp.com/biz/east-is-east-vancouver-2?osq=Middle+Eastern+Food");
        restaurants.add(east);

        Restaurant jamjar = new Restaurant("Jamjar Folk Lebanese Food");
        jamjar.addTags("cheap");
        jamjar.addTags("dinner");
        jamjar.addTags("lunch");
        jamjar.addTags("middle");
        jamjar.addTags("vegetarian");
        jamjar.setUrl("https://www.yelp.com/biz/jamjar-folk-lebanes-food-vancouver?osq=Middle+Eastern+Food");
        restaurants.add(jamjar);

        Restaurant basha = new Restaurant("Al Basha");
        basha.addTags("cheap");
        basha.addTags("dinner");
        basha.addTags("lunch");
        basha.addTags("middle");
        basha.setUrl("https://www.yelp.com/biz/al-basha-vancouver?osq=Middle+Eastern+Food");
        restaurants.add(basha);

        Restaurant chili = new Restaurant("The Chili House");
        chili.addTags("cheap");
        chili.addTags("lunch");
        chili.addTags("asian");
        chili.addTags("spicy");
        chili.addTags("sit");
        chili.setUrl("https://www.yelp.com/biz/the-chili-house-vancouver-3?osq=Spicy+Food");
        restaurants.add(chili);

        Restaurant joojak = new Restaurant("Joojak Restaurant");
        joojak.addTags("dinner");
        joojak.addTags("lunch");
        joojak.addTags("asian");
        joojak.addTags("spicy");
        joojak.addTags("sit");
        joojak.setUrl("https://www.yelp.com/biz/joojak-restaurant-vancouver?osq=Spicy+Food");
        restaurants.add(joojak);

        Restaurant ajisai = new Restaurant("Ajisai Sushi Bar");
        ajisai.addTags("dinner");
        ajisai.addTags("lunch");
        ajisai.addTags("asian");
        ajisai.addTags("sit");
        ajisai.setUrl("https://www.yelp.com/biz/ajisai-sushi-bar-vancouver?osq=Sushi");
        restaurants.add(ajisai);

        Restaurant jam = new Restaurant("Jam Cafe on Beatty");
        jam.addTags("breakfast");
        jam.addTags("western");
        jam.addTags("sit");
        jam.setUrl("https://www.yelp.com/biz/jam-cafe-on-beatty-vancouver?osq=Breakfast");
        restaurants.add(jam);

        Restaurant medina = new Restaurant("Medina Cafe");
        medina.addTags("breakfast");
        medina.addTags("middle");
        medina.addTags("sit");
        medina.setUrl("https://www.yelp.com/biz/medina-cafe-vancouver?osq=Breakfast");
        restaurants.add(medina);

        Restaurant marulilu = new Restaurant("Marulilu Cafe");
        marulilu.addTags("cheap");
        marulilu.addTags("lunch");
        marulilu.addTags("breakfast");
        marulilu.addTags("asian");
        marulilu.addTags("sit");
        marulilu.setUrl("https://www.yelp.com/biz/marulilu-cafe-vancouver?osq=Breakfast");
        restaurants.add(marulilu);

        Restaurant acorn = new Restaurant("The Acorn");
        acorn.addTags("lunch");
        acorn.addTags("vegetarian");
        acorn.setUrl("https://www.yelp.com/biz/the-acorn-vancouver?osq=Vegetarian+Food");
        restaurants.add(acorn);

        Restaurant bandidas = new Restaurant("Bandidas Taqueria");
        bandidas.addTags("cheap");
        bandidas.addTags("lunch");
        bandidas.addTags("breakfast");
        bandidas.addTags("western");
        bandidas.addTags("vegetarian");
        bandidas.addTags("spicy");
        bandidas.setUrl("https://www.yelp.com/biz/bandidas-taqueria-vancouver?osq=Spicy+Mexican+Food");
        restaurants.add(bandidas);

        Restaurant mexican = new Restaurant("The Mexican Antojitos Y Cantina");
        mexican.addTags("cheap");
        mexican.addTags("dinner");
        mexican.addTags("lunch");
        mexican.addTags("western");
        mexican.addTags("spicy");
        mexican.addTags("sit");
        mexican.setUrl("https://www.yelp.com/biz/the-mexican-antojitos-y-cantina-vancouver?osq=Spicy+Mexican+Food");
        restaurants.add(mexican);

        Restaurant kobob = new Restaurant("Kobob Burger");
        kobob.addTags("cheap");
        kobob.addTags("dinner");
        kobob.addTags("lunch");
        kobob.addTags("asian");
        kobob.setUrl("https://www.yelp.com/biz/kobob-burger-vancouver-2?osq=Burgers");
        restaurants.add(kobob);

        Restaurant rain = new Restaurant("Rain or Shine Ice Cream");
        rain.addTags("cheap");
        rain.addTags("dessert");
        rain.setUrl("https://www.yelp.com/biz/rain-or-shine-ice-cream-vancouver?osq=Ice+Cream+%26+Frozen+Yogurt");
        restaurants.add(rain);

        Restaurant tangram = new Restaurant("Tangram Creamery");
        tangram.addTags("cheap");
        tangram.addTags("dessert");
        tangram.setUrl("https://www.yelp.com/biz/tangram-creamery-vancouver?osq=Ice+Cream+%26+Frozen+Yogurt");
        restaurants.add(tangram);

        Restaurant yek = new Restaurant("Yek O Yek");
        yek.addTags("cheap");
        yek.addTags("middle");
        yek.addTags("dessert");
        yek.setUrl("https://www.yelp.com/biz/yek-o-yek-vancouver-2?osq=Middle+Eastern+Dessert");
        restaurants.add(yek);

        Restaurant five = new Restaurant("Five Guys");
        five.addTags("cheap");
        five.addTags("fast");
        five.addTags("dinner");
        five.addTags("lunch");
        five.addTags("western");
        five.setUrl("https://www.yelp.com/biz/five-guys-vancouver-3?osq=5+Guys+Famous+Burgers+and+Fries");
        restaurants.add(five);

        Restaurant kyo = new Restaurant("Kyo Korean BBQ & Sushi House");
        kyo.addTags("dinner");
        kyo.addTags("lunch");
        kyo.addTags("asian");
        kyo.addTags("sit");
        kyo.setUrl("https://www.yelp.com/biz/kyo-korean-bbq-and-sushi-house-vancouver?osq=Korean+bbq");
        restaurants.add(kyo);

        Restaurant gyu = new Restaurant("Gyu-Kaku Japanese BBQ");
        gyu.addTags("dinner");
        gyu.addTags("lunch");
        gyu.addTags("asian");
        gyu.addTags("sit");
        gyu.setUrl("https://www.yelp.com/biz/gyu-kaku-japanese-bbq-vancouver-3?osq=Korean+bbq");
        restaurants.add(gyu);

        Restaurant kurumucho = new Restaurant("Kurumucho Japanese Taco Shop");
        kurumucho.addTags("lunch");
        kurumucho.addTags("asian");
        kurumucho.addTags("vegetarian");
        kurumucho.setUrl("https://www.yelp.com/biz/kurumucho-japanese-taco-shop-vancouver-2?osq=Vegetarian+Friendly");
        restaurants.add(kurumucho);
    }
}
