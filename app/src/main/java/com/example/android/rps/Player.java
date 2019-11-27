package com.example.android.rps;

/**
 * Created by Hania on 2019-09-08.
 */

import java.util.Scanner;

public class Player implements IPlayer{
    private int pointPlayer;
    private String movePlayer;

    @Override
    public void setMovePlayer(String movePlayer) {
        this.movePlayer = movePlayer;
    }

    @Override
    public String getMovePlayer() {
        return movePlayer;
    }

    @Override
    public int getPointPlayer() {
        return pointPlayer;
    }
    @Override
    public void setPointPlayer(int pointPlayer) {
        this.pointPlayer = pointPlayer;
    }

    @Override
    public int pointsPlayer(){
        return pointPlayer++;
    }
}

