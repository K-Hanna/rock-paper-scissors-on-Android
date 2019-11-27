package com.example.android.rps;

/**
 * Created by Hania on 2019-09-08.
 */

public interface IPlayer {
    int pointsPlayer();
    void setMovePlayer(String movePlayer);
    String getMovePlayer();
    int getPointPlayer();
    void setPointPlayer(int pointPlayer);
}
