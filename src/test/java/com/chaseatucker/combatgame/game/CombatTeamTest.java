package com.chaseatucker.combatgame.game;

import com.chaseatucker.combatgame.character.Barbarian;
import com.chaseatucker.combatgame.character.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatTeamTest {

    CombatTeam combatTeam;

    @Before
    public void setUp() throws Exception {
        combatTeam = new CombatTeam("7th Sun");
        combatTeam.getCharacters().add(new Wizard("staff", "Merlin"));
        combatTeam.getCharacters().add(new Barbarian("battle axe", "Brute"));
    }

    @Test
    public void getName() {
        assertEquals("7th Sun", combatTeam.getName());
    }

    @Test
    public void getSpecialsRemaining() {
    }

    @Test
    public void setSpecialsRemaining() {
    }

    @Test
    public void testToString() {
    }
}