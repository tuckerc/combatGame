/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.chaseatucker.combatgame;

import com.chaseatucker.combatgame.character.Barbarian;
import com.chaseatucker.combatgame.character.Character;
import com.chaseatucker.combatgame.character.Wizard;
import com.chaseatucker.combatgame.game.CombatTeam;
import com.chaseatucker.combatgame.game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CombatTeam team1;
        CombatTeam team2;
        Character team1Character1;
        Character team1Character2;
        Character team2Character1;
        Character team2Character2;

        System.out.println("************************************");
        System.out.println("******** Combat Tournament *********");
        System.out.println("************************************");

        // Get input from command line to build teams
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            System.out.println("\n***** Team 1 *****");
            team1 = getTeam(reader);
            System.out.println("--Character 1--");
            team1Character1 = getCharacter(reader);
            System.out.println("--Character 2--");
            team1Character2 = getCharacter(reader);
            team1.getCharacters().add(team1Character1);
            team1.getCharacters().add(team1Character2);
            System.out.println("\n***** Team 2 *****");
            team2 = getTeam(reader);
            System.out.println("--Character 1--");
            team2Character1 = getCharacter(reader);
            System.out.println("--Character 2--");
            team2Character2 = getCharacter(reader);
            team2.getCharacters().add(team2Character1);
            team2.getCharacters().add(team2Character2);

            // Build game
            Game game = new Game(team1, team2);

            // Combat until one team's character's are all dead
            int team1HealthTotal = 1;
            int team2HealthTotal = 1;
            while(team1HealthTotal > 0 && team2HealthTotal > 0) {
                game.battleRound();
                team1HealthTotal = 0;
                for(Character character : team1.getCharacters()) {
                    team1HealthTotal += character.getHealth();
                }
                team2HealthTotal = 0;
                for(Character character : team2.getCharacters()) {
                    team2HealthTotal += character.getHealth();
                }
            }

            if(team1HealthTotal == 0) {
                System.out.println("\n\n^^^^^^^^^^ Team " + team1.getName() + " is victorious! ^^^^^^^^^^");
            } else {
                System.out.println("\n\n^^^^^^^^^^ Team " + team2.getName() + " is victorious! ^^^^^^^^^^");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CombatTeam getTeam(BufferedReader reader) throws IOException {
        System.out.print("Enter team  name: ");
        return new CombatTeam(reader.readLine());
    }

    private static Character getCharacter(BufferedReader reader) throws IOException {
        System.out.print("Press 1 for Wizard or 2 for Barbarian: ");
        String characterSelection = reader.readLine();
        try{
            int selection = Integer.parseInt(characterSelection);
            if(selection == 1) {
                return new Wizard(getWeapon(reader), getCharacterName(reader));
            } else if(selection == 2) {
                return new Barbarian(getWeapon(reader), getCharacterName(reader));
            } else {
                System.out.println("You must enter either 1 or 2");
                getCharacter(reader);
            }
        } catch (NumberFormatException e) {
            System.out.println("You must enter either 1 or 2");
            getCharacter(reader);
        }
        return new Barbarian("default", "default");
    }

    private static String getCharacterName(BufferedReader reader) throws IOException {
        System.out.print("Enter character name: ");
        return reader.readLine();
    }

    private static String getWeapon(BufferedReader reader) throws IOException {
        System.out.print("Enter primary weapon: ");
        return reader.readLine();
    }
}
