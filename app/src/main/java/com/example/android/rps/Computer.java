package com.example.android.rps;

/**
 * Created by Hania on 2019-09-08.
 */

import java.util.Random;

public class Computer implements IComputer{
    private int pointComp;
    private Random random = new Random();
    private String moveComp;

    @Override
    public void setMoveComp() {
        int move = random.nextInt(3);
        String moveComp;
        switch (move){
            case 0:
                moveComp = "rock";
                break;
            case 1:
                moveComp = "paper";
                break;
            case 2:
                moveComp = "scissors";
                break;
            default:
                moveComp = "";
        }
        this.moveComp = moveComp;
    }

    @Override
    public String getMoveComp() {
        return moveComp;
    }
    @Override
    public int getPointComp(){
        return pointComp;
    }
    @Override
    public void setPointComp(int pointComp) {
        this.pointComp = pointComp;
    }

    @Override
    public int pointsComp(){
        return pointComp++;
    }
}


