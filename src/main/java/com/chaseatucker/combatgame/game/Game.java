package com.chaseatucker.combatgame.game;

import com.chaseatucker.combatgame.character.Character;
import com.chaseatucker.combatgame.character.IllegalHealthAssignmentException;

import java.util.Collections;
import java.util.Random;

/**
 * Game class for combatGame
 */
public class Game {
    // Class constants
    private static final int MIN_ROUNDS = 0;

    // Instance variables
    private CombatTeam team1;
    private CombatTeam team2;
    private int rounds;

    /**
     * Game constructor.
     * @param team1 First CombatTeam
     * @param team2 Second CombatTeam
     */
    public Game(CombatTeam team1, CombatTeam team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Getter for first CombatTeam
     * @return First CombatTeam
     */
    public CombatTeam getTeam1() {
        return team1;
    }

    /**
     * Getter for second CombatTeam
     * @return Second CombatTeam
     */
    public CombatTeam getTeam2() {
        return team2;
    }

    /**
     * Method for simulating a round of combat between two characters.
     * The round is split up into two halves.
     */
    public void battleRound() {
        System.out.println("\n!!!!!!!!!! Round " + this.getRounds() +
                " !!!!!!!!!!\n");

        attackDefendSequence(team1, team2, "first");
        attackDefendSequence(team2, team1, "second");

        // increment game rounds
        try {
            this.setRounds(this.getRounds() + 1);
        } catch (IllegalRoundsAssignmentException e) {
            e.printStackTrace();
        }
    }

    /**
     * A non-dead character from each team is chosen at random.
     * In the first round, the team 1 character attacks while
     * the team 2 character defends. In the second half the team
     * 2 character attacks while the team 1 character defends.
     * @param attackingTeam attacking CombatTeam
     * @param defendingTeam defending CombatTeam
     * @param half current half of the round
     */
    private void attackDefendSequence(CombatTeam attackingTeam, CombatTeam defendingTeam,
                                             String half) {
        // shuffle the order on the teams
        Collections.shuffle(attackingTeam.getCharacters());
        Collections.shuffle(defendingTeam.getCharacters());

        // get the first character from each team that is still alive
        Character attackingCharacter = attackingTeam.getCharacters().get(0);
        for(int i = 1; i < attackingTeam.getCharacters().size() &&
                attackingCharacter.getHealth() <= 0; i++) {
            attackingCharacter = attackingTeam.getCharacters().get(i);
        }

        Character defendingCharacter = defendingTeam.getCharacters().get(0);
        for(int i = 1; i < defendingTeam.getCharacters().size() &&
                defendingCharacter.getHealth() <= 0; i++) {
            defendingCharacter = defendingTeam.getCharacters().get(i);
        }

        // determine if either team will use a special
        int attackingCharacterSpecialResult =
                (int) Math.ceil(Math.random() * attackingTeam.getSpecialsRemaining());

        int attackResult = 0;
        int defendResult = 0;
        // if special result is 0, special is used
        if(attackingCharacterSpecialResult == 0) {
            int[] specialResult = attackingCharacter.special();
            attackResult = specialResult[0];
            attackResult += specialResult[1];
            try {
                attackingTeam.setSpecialsRemaining(attackingTeam.getSpecialsRemaining() - 1);
            } catch (IllegalSpecialAssignmentException e) {
                e.printStackTrace();
            }
        } else {
            // team 1 attacks first
            attackResult = attackingCharacter.attack();
        }
        // team 2 defends first
        defendResult = defendingCharacter.defend();

        // determine outcome of first half
        int netDamage = Math.min(Math.max(attackResult - defendResult, 0),
                defendingCharacter.getHealth());
        try {
            defendingCharacter.setHealth(defendingCharacter.getHealth() - netDamage);
        } catch (IllegalHealthAssignmentException e) {
            e.printStackTrace();
        }

        // print first half results
        System.out.println("\n** Round " + this.getRounds() + ", " + half + " half results:");
        System.out.println(defendingCharacter.getName() + " loses " + netDamage +
                " health points\n");
    }

    /**
     * Getter for the number of combat rounds.
     * @return Number of rounds of combat.
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * Setter for the number of combat rounds.
     * @param rounds Number of combat rounds
     * @throws IllegalRoundsAssignmentException Rounds must be greater than MIN_ROUNDS
     */
    public void setRounds(int rounds) throws IllegalRoundsAssignmentException {
        if(rounds < MIN_ROUNDS) {
            throw new IllegalRoundsAssignmentException("rounds must be greater than " +
                    MIN_ROUNDS);
        }
        this.rounds = rounds;
    }

    /**
     * toString() override for Game class.
     * @return String representation of Game
     */
    @Override
    public String toString() {
        return "Game{" +
                "team1=" + team1 + "\n  " +
                "team2=" + team2 + "\n  " +
                "rounds=" + rounds +
                '}';
    }
}
