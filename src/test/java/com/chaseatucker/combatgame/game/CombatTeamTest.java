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
        assertEquals(10, combatTeam.getSpecialsRemaining());
        try {
            combatTeam.setSpecialsRemaining(5);
        } catch (IllegalSpecialAssignmentException e) {
            e.printStackTrace();
        }
        assertEquals(5, combatTeam.getSpecialsRemaining());
    }

    @Test
    public void setSpecialsRemaining() {
        try {
            combatTeam.setSpecialsRemaining(5);
        } catch (IllegalSpecialAssignmentException e) {
            e.printStackTrace();
        }
        assertEquals(5, combatTeam.getSpecialsRemaining());
    }

    @Test (expected = IllegalSpecialAssignmentException.class)
    public void setSpecialRemainingLowSpecialException() throws IllegalSpecialAssignmentException {
        combatTeam.setSpecialsRemaining(-10);
    }

    @Test (expected = IllegalSpecialAssignmentException.class)
    public void setSpecialRemainingHighSpecialException() throws IllegalSpecialAssignmentException {
        combatTeam.setSpecialsRemaining(20);
    }

    @Test
    public void testToString() {
        assertEquals("CombatTeam{name='7th Sun,\n" +
                "  characters=[Character{weapon='staff', name='Merlin', attackSkills=[AttackSkill{name=ACID_SPRAY, attackStrength=30}, AttackSkill{name=FREEZE, attackStrength=20}, AttackSkill{name=FIREBALL, attackStrength=30}, AttackSkill{name=SHOCK, attackStrength=25}], defendSkills=[DefendSkill{name=CLOAK, defendStrength=15}, DefendSkill{name=TELEPORT, defendStrength=20}], health=100}, Character{weapon='battle axe', name='Brute', attackSkills=[AttackSkill{name=SLASH, attackStrength=25}, AttackSkill{name=PIERCE, attackStrength=25}, AttackSkill{name=BLUDGEON, attackStrength=25}], defendSkills=[DefendSkill{name=BLOCK, defendStrength=15}, DefendSkill{name=SHIELD, defendStrength=20}], health=100}],\n" +
                "  specialsRemaining=10}",
                combatTeam.toString());
    }
}