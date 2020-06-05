package com.chaseatucker.combatgame.game;

import com.chaseatucker.combatgame.character.Barbarian;
import com.chaseatucker.combatgame.character.Character;
import com.chaseatucker.combatgame.character.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        CombatTeam team1 = new CombatTeam("Team 1");
        team1.getCharacters().add(
                new Wizard("staff", "Merlin"));
        team1.getCharacters().add(
                new Barbarian("battle axe", "Brute"));
        CombatTeam team2 = new CombatTeam("Team 2");
        team2.getCharacters().add(
                new Barbarian("sword", "Thor"));
        team2.getCharacters().add(
                new Wizard("scepter", "Gandoff"));
        game = new Game(team1, team2);
    }

    @Test
    public void getTeam1() {
        assertEquals("Team 1", game.getTeam1().getName());
    }

    @Test
    public void getTeam2() {
        assertEquals("Team 2", game.getTeam2().getName());
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
    public void battleRound() {
        // Combat until one team's character's are all dead
        int team1HealthTotal = 1;
        int team2HealthTotal = 1;
        while(team1HealthTotal > 0 && team2HealthTotal > 0) {
            game.battleRound();
            team1HealthTotal = 0;
            for(Character character : game.getTeam1().getCharacters()) {
                team1HealthTotal += character.getHealth();
            }
            team2HealthTotal = 0;
            for(Character character : game.getTeam2().getCharacters()) {
                team2HealthTotal += character.getHealth();
            }
        }

        if(team1HealthTotal == 0) {
            System.out.println("\n\n^^^^^^^^^^ Team " + game.getTeam1().getName() + " is victorious! ^^^^^^^^^^");
        } else {
            System.out.println("\n\n^^^^^^^^^^ Team " + game.getTeam2().getName() + " is victorious! ^^^^^^^^^^");
        }
    }

    @Test
    public void testToString() {
        assertEquals("Game{team1=CombatTeam{name='Team 1,\n" +
                "  characters=[Character{weapon='staff', name='Merlin', attackSkills=[AttackSkill{name=ACID_SPRAY, attackStrength=30}, AttackSkill{name=FREEZE, attackStrength=20}, AttackSkill{name=FIREBALL, attackStrength=30}, AttackSkill{name=SHOCK, attackStrength=25}], defendSkills=[DefendSkill{name=CLOAK, defendStrength=15}, DefendSkill{name=TELEPORT, defendStrength=20}], health=100}, Character{weapon='battle axe', name='Brute', attackSkills=[AttackSkill{name=SLASH, attackStrength=25}, AttackSkill{name=PIERCE, attackStrength=25}, AttackSkill{name=BLUDGEON, attackStrength=25}], defendSkills=[DefendSkill{name=BLOCK, defendStrength=15}, DefendSkill{name=SHIELD, defendStrength=20}], health=100}],\n" +
                "  specialsRemaining=10}\n" +
                "  team2=CombatTeam{name='Team 2,\n" +
                "  characters=[Character{weapon='sword', name='Thor', attackSkills=[AttackSkill{name=SLASH, attackStrength=25}, AttackSkill{name=PIERCE, attackStrength=25}, AttackSkill{name=BLUDGEON, attackStrength=25}], defendSkills=[DefendSkill{name=BLOCK, defendStrength=15}, DefendSkill{name=SHIELD, defendStrength=20}], health=100}, Character{weapon='scepter', name='Gandoff', attackSkills=[AttackSkill{name=ACID_SPRAY, attackStrength=30}, AttackSkill{name=FREEZE, attackStrength=20}, AttackSkill{name=FIREBALL, attackStrength=30}, AttackSkill{name=SHOCK, attackStrength=25}], defendSkills=[DefendSkill{name=CLOAK, defendStrength=15}, DefendSkill{name=TELEPORT, defendStrength=20}], health=100}],\n" +
                "  specialsRemaining=10}\n" +
                "  rounds=0}", game.toString());
    }
}