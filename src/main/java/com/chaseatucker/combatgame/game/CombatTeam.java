package com.chaseatucker.combatgame.game;

import com.chaseatucker.combatgame.character.Character;

import java.util.LinkedList;
import java.util.List;

/**
 * CombatTeam class for combatGame
 */
public class CombatTeam {
    // class constants
    private static final int MIN_SPECIALS = 0;
    private static final int MAX_SPECIALS = 10;

    // instance variables
    private String name;
    private List<Character> characters;
    private int specialsRemaining;

    /**
     * CombatTeam constructor. Gives team 10 specials to use.
     * @param name CombatTeam name
     */
    public CombatTeam(String name) {
        this.setName(name);
        this.characters = new LinkedList<>();
        try {
            this.setSpecialsRemaining(10);
        } catch (IllegalSpecialAssignmentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for team name.
     * @return CombatTeam name
     */
    public String getName() {
        return name;
    }

    /**
     * Private setter for team name.
     * @param name CombatTeam name
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for team characters.
     * @return Team characters
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Getter for remaining team specials.
     * @return Remaining team specials
     */
    public int getSpecialsRemaining() {
        return specialsRemaining;
    }

    /**
     * Setter for remaining team specials.
     * @param specialsRemaining Remaining team specials
     * @throws IllegalSpecialAssignmentException specialsRemaining must be greater than MIN_SPECIALS
     * and less than MAX_SPECIALS.
     */
    public void setSpecialsRemaining(int specialsRemaining) throws IllegalSpecialAssignmentException {
        if(specialsRemaining < MIN_SPECIALS || specialsRemaining > MAX_SPECIALS) {
            throw new IllegalSpecialAssignmentException("specials must be greater than " +
                    MIN_SPECIALS);
        }
        this.specialsRemaining = specialsRemaining;
    }

    /**
     * toString() override for the CombatTeam class.
     * @return String representation of the CombatTeam instance.
     */
    @Override
    public String toString() {
        return "CombatTeam{" +
                "name='" + name + ",\n  " +
                "characters=" + characters + ",\n  " +
                "specialsRemaining=" + specialsRemaining +
                '}';
    }
}
