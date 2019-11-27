package com.example.android.rps;

/**
 * Created by Hania on 2019-09-08.
 */

public interface IPlay {
    String check();
    String message(String firstName);
    void setPlayer(String move);
    IComputer getComp();
    IPlayer getPlayer();
}

