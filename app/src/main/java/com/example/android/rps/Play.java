package com.example.android.rps;

/**
 * Created by Hania on 2019-09-08.
 */

public class Play implements IPlay {

    private IPlayer player = new Player();
    private IComputer comp = new Computer();

    @Override
    public void setPlayer(String move) {
        player.setMovePlayer(move);
    }
    @Override
    public IComputer getComp() {
        return comp;
    }
    @Override
    public IPlayer getPlayer() {
        return player;
    }

    @Override
    public String check(){
        if(player.getMovePlayer().equals(comp.getMoveComp()))
            return " ";
        switch (player.getMovePlayer()) {
            case "rock":
                switch (comp.getMoveComp()) {
                    case "paper":
                        comp.pointsComp();
                        return "Paper wraps rock.";
                    case "scissors":
                        player.pointsPlayer();
                        return "Rock crushes scissors.";
                }
            case "paper":
                switch (comp.getMoveComp()) {
                    case "rock":
                        player.pointsPlayer();
                        return "Paper wraps rock.";
                    case "scissors":
                        comp.pointsComp();
                        return "Scissors cut paper.";
                }
            case "scissors":
                switch (comp.getMoveComp()) {
                    case "paper":
                        player.pointsPlayer();
                        return "Scissors cut paper.";
                    case "rock":
                        comp.pointsComp();
                        return "Rock crushes scissors.";
                }
        } return "";
    }

    @Override
    public String message(String firstName){
        if(player.pointsPlayer()==comp.pointsComp())
            return "It's a tie.";
        else if(player.pointsPlayer() > comp.pointsComp())
            return firstName + " won.";
        else
            return firstName + " lost.";
    }
}
