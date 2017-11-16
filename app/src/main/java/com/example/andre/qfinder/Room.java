package com.example.andre.qfinder;

/**
 * Created by py344 on 2017-11-13.
 */

public class Room {
    private String id;
    private String roomCode;
    private int numMembers;
    private String questionsIDs;
    private boolean quizStart;
    private int finishedQuiz;
    private int price;
    private int fastFood;
    private int lunch;
    private int dinner;
    private int breakfast;
    private int western;
    private int middleEastern;
    private int asian;
    private int vegetarian;
    private int dessert;
    private int spicy;
    private int sitDown;



    public Room(String roomCode) {
        this.roomCode = roomCode;
        numMembers = 1;
        questionsIDs = "";
        quizStart = false;
        finishedQuiz = 0;
        price = 0;
        fastFood = 0;
        lunch = 0;
        dinner = 0;
        breakfast = 0;
        western = 0;
        middleEastern = 0;
        asian = 0;
        vegetarian = 0;
        dessert = 0;
        spicy = 0;
        sitDown = 0;
    }

    public void generateQuiz() {
        //implement
    }

    public String getQuestionsIDs() {
        return questionsIDs;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public void setNumMembers(int numMembers) {
        this.numMembers = numMembers;
    }

    public boolean isQuizStart() {
        return quizStart;
    }

    public void setQuizStart(boolean quizStart) {
        this.quizStart = quizStart;
    }

    public int getFinishedQuiz() {
        return finishedQuiz;
    }

    public void setFinishedQuiz(int finishedQuiz) {
        this.finishedQuiz = finishedQuiz;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFastFood() {
        return fastFood;
    }

    public void setFastFood(int fastFood) {
        this.fastFood = fastFood;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getDinner() {
        return dinner;
    }

    public void setDinner(int dinner) {
        this.dinner = dinner;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getWestern() {
        return western;
    }

    public void setWestern(int western) {
        this.western = western;
    }

    public int getMiddleEastern() {
        return middleEastern;
    }

    public void setMiddleEastern(int middleEastern) {
        this.middleEastern = middleEastern;
    }

    public int getAsian() {
        return asian;
    }

    public void setAsian(int asian) {
        this.asian = asian;
    }

    public int getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(int vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getDessert() {
        return dessert;
    }

    public void setDessert(int dessert) {
        this.dessert = dessert;
    }

    public int getSpicy() {
        return spicy;
    }

    public void setSpicy(int spicy) {
        this.spicy = spicy;
    }

    public int getSitDown() {
        return sitDown;
    }

    public void setSitDown(int sitDown) {
        this.sitDown = sitDown;
    }
}
