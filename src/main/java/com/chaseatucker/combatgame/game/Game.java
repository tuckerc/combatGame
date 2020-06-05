package com.chaseatucker.combatgame.game;

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
