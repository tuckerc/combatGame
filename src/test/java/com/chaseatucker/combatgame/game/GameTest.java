package com.chaseatucker.combatgame.game;

import com.chaseatucker.combatgame.character.Barbarian;
import com.chaseatucker.combatgame.character.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game("Chase", "Danae");
        game.getTeam1().getCharacters().add(
                new Wizard("staff", "Merlin"));
        game.getTeam1().getCharacters().add(
                new Barbarian("battle axe", "Brute"));
        game.getTeam2().getCharacters().add(
                new Barbarian("sword", "Thor"));
        game.getTeam2().getCharacters().add(
                new Wizard("scepter", "Gandoff"));
    }

    @Test
    public void getTeam1() {
        assertEquals("Chase", game.getTeam1().getName());
    }

    @Test
    public void getTeam2() {
        assertEquals("Danae", game.getTeam2().getName());
    }

    @Test
    public void getRounds() {
        assertEquals(0, game.getRounds());
        try {
            game.setRounds(1);
        } catch (IllegalRoundsAssignmentException e) {
            e.printStackTrace();
        }
        assertEquals(1, game.getRounds());
    }

    @Test
    public void setRounds() {
        try {
            game.setRounds(13);
        } catch (IllegalRoundsAssignmentException e) {
            e.printStackTrace();
        }
        assertEquals(13, game.getRounds());
    }

    @Test (expected = IllegalRoundsAssignmentException.class)
    public void setRoundsException() throws IllegalRoundsAssignmentException {
        game.setRounds(-30);
    }

    @Test
    public void testToString() {
        assertEquals("Game{team1=CombatTeam{name='Chase,\n" +
                "  characters=[Character{weapon='staff', name='Merlin', attackSkills=[AttackSkill{name=ACID_SPRAY, attackStrength=20}, AttackSkill{name=FREEZE, attackStrength=10}, AttackSkill{name=FIREBALL, attackStrength=20}, AttackSkill{name=SHOCK, attackStrength=15}], defendSkills=[DefendSkill{name=CLOAK, defendStrength=15}, DefendSkill{name=TELEPORT, defendStrength=20}], health=100}, Character{weapon='battle axe', name='Brute', attackSkills=[AttackSkill{name=SLASH, attackStrength=15}, AttackSkill{name=PIERCE, attackStrength=15}, AttackSkill{name=BLUDGEON, attackStrength=15}], defendSkills=[DefendSkill{name=BLOCK, defendStrength=10}, DefendSkill{name=SHIELD, defendStrength=20}], health=100}],\n" +
                "  specialsRemaining=10}\n" +
                "  team2=CombatTeam{name='Danae,\n" +
                "  characters=[Character{weapon='sword', name='Thor', attackSkills=[AttackSkill{name=SLASH, attackStrength=15}, AttackSkill{name=PIERCE, attackStrength=15}, AttackSkill{name=BLUDGEON, attackStrength=15}], defendSkills=[DefendSkill{name=BLOCK, defendStrength=10}, DefendSkill{name=SHIELD, defendStrength=20}], health=100}, Character{weapon='scepter', name='Gandoff', attackSkills=[AttackSkill{name=ACID_SPRAY, attackStrength=20}, AttackSkill{name=FREEZE, attackStrength=10}, AttackSkill{name=FIREBALL, attackStrength=20}, AttackSkill{name=SHOCK, attackStrength=15}], defendSkills=[DefendSkill{name=CLOAK, defendStrength=15}, DefendSkill{name=TELEPORT, defendStrength=20}], health=100}],\n" +
                "  specialsRemaining=10}\n" +
                "  rounds=0}", game.toString());
    }
}