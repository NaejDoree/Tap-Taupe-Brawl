package com.codingame.game;

import java.util.List;

import com.codingame.gameengine.core.AbstractPlayer.TimeoutException;
import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.MultiplayerGameManager;
import com.codingame.gameengine.core.Tooltip;
import com.codingame.gameengine.module.entities.Circle;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.google.inject.Inject;

public class Referee extends AbstractReferee {
    private static int WIDTH = 1920;
    private static int HEIGHT = 1080;
    
    @Inject private MultiplayerGameManager<Player> gameManager;
    @Inject private GraphicEntityModule graphicEntityModule;

    private void sendPlayerInputs() {
        List<Player> allPlayers = gameManager.getPlayers();
        for (Player p : gameManager.getActivePlayers()) {
            p.sendInputLine(String.valueOf(p.y));
            p.sendInputLine(String.valueOf(allPlayers.get((p.getIndex() + 1) % 2).y));
            p.execute();
        }
    }



    @Override
    public void init() {
        gameManager.setFrameDuration(100);
   }

    @Override
    public void gameTurn(int turn) {
        // Send new inputs with the updated positions
        sendPlayerInputs();

        
        if (turn == 10) {
            gameManager.getPlayer(0).deactivate();
        } else if (false) {
            gameManager.getPlayer(1).deactivate();
        }

        if (gameManager.getActivePlayers().size() < 2) {
            gameManager.endGame();
        }
    }

    @Override
    public void onEnd() {
        for (Player p : gameManager.getPlayers()) {
            p.setScore(p.isActive() ? 1 : 0);
        }
    }
}
