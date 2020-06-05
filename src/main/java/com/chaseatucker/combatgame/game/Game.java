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

    public void battleRound() {
        System.out.println("\n!!!!!!!!!! Round " + this.getRounds() +
                " !!!!!!!!!!\n");

        // shuffle the order on the teams
        Collections.shuffle(team1.getCharacters());
        Collections.shuffle(team2.getCharacters());

        // get the first character from each team that is still alive
        Character team1Character = team1.getCharacters().get(0);
        for(int i = 1; i < team1.getCharacters().size() &&
                team1Character.getHealth() <= 0; i++) {
            team1Character = team1.getCharacters().get(i);
        }

        Character team2Character = team2.getCharacters().get(0);
        for(int i = 1; i < team2.getCharacters().size() &&
                team2Character.getHealth() <= 0; i++) {
            team2Character = team2.getCharacters().get(i);
        }

        // determine if either team will use a special
        Random random = new Random();
        int team1SpecialResult = random.nextInt(team1.getSpecialsRemaining());
        int team2SpecialResult = random.nextInt(team2.getSpecialsRemaining());

        int team1AttackResult = 0;
        int team2AttackResult = 0;
        int team1DefendResult = 0;
        int team2DefendResult = 0;
        // if special result is 0, special is used
        if(team1SpecialResult == 0) {
            int[] specialResult = team1Character.special();
            team1AttackResult = specialResult[0];
            team1DefendResult = specialResult[1];
            try {
                team1.setSpecialsRemaining(team1.getSpecialsRemaining() - 1);
            } catch (IllegalSpecialAssignmentException e) {
                e.printStackTrace();
            }
        } else {
            // team 1 attacks first
            team1AttackResult = team1Character.attack();
        }
        // team 2 defends first
        team2DefendResult = team2Character.defend();

        // determine outcome of first half
        int team1NetDamage = Math.min(Math.max(team2AttackResult - team1DefendResult, 0),
                team1Character.getHealth());
        int team2NetDamage = Math.min(Math.max(team1AttackResult - team2DefendResult, 0),
                team2Character.getHealth());
        try {
            team1Character.setHealth(team1Character.getHealth() - team1NetDamage);
            team2Character.setHealth(team2Character.getHealth() - team2NetDamage);
        } catch (IllegalHealthAssignmentException e) {
            e.printStackTrace();
        }

        // print first half results
        System.out.println("\n** Round " + this.getRounds() + ", first half results:");
        System.out.println(team1Character.getName() + " loses " + team1NetDamage +
                " health points");
        System.out.println(team2Character.getName() + " loses " + team2NetDamage +
                " health points\n");

        // reset results
        team1AttackResult = 0;
        team1DefendResult = 0;
        team2AttackResult = 0;
        team2DefendResult = 0;

        // if special result is 0, special is used
        if(team2SpecialResult == 0) {
            int[] specialResult = team2Character.special();
            team2AttackResult = specialResult[0];
            team2DefendResult = specialResult[1];
            try {
                team2.setSpecialsRemaining(team2.getSpecialsRemaining() - 1);
            } catch (IllegalSpecialAssignmentException e) {
                e.printStackTrace();
            }
        } else {
            // team 2 attacks second
            team2AttackResult = team2Character.attack();
        }
        // team 1 defends second
        team1DefendResult = team1Character.defend();

        // determine outcome of first half
        team1NetDamage = Math.min(Math.max(team2AttackResult - team1DefendResult, 0),
                team1Character.getHealth());
        team2NetDamage = Math.min(Math.max(team1AttackResult - team2DefendResult, 0),
                team2Character.getHealth());
        try {
            team1Character.setHealth(team1Character.getHealth() - team1NetDamage);
            team2Character.setHealth(team2Character.getHealth() - team2NetDamage);
        } catch (IllegalHealthAssignmentException e) {
            e.printStackTrace();
        }

        // print second half results
        System.out.println("\n** Round " + this.getRounds() + ", second half results:");
        System.out.println(team1Character.getName() + " loses " + team1NetDamage +
                " health points");
        System.out.println(team2Character.getName() + " loses " + team2NetDamage +
                " health points");

        // increment game rounds
        try {
            this.setRounds(this.getRounds() + 1);
        } catch (IllegalRoundsAssignmentException e) {
            e.printStackTrace();
        }
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
