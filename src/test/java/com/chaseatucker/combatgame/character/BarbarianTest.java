package com.chaseatucker.combatgame.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BarbarianTest {

    Barbarian barbarian;

    @Before
    public void setUp() throws Exception {
        barbarian = new Barbarian("sword", "Brute");
    }

    @Test
    public void attack() {
        for(int j = 0; j < 100; j++) {
            try {
                barbarian.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 20; i++) {
                int attackValue = barbarian.attack();
                assertTrue(attackValue <= 20 && attackValue >= 0);
                try {
                    barbarian.setHealth((int) (barbarian.getHealth() * 0.95));
                } catch (IllegalHealthAssignmentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void defend() {
        for(int j = 0; j < 100; j++) {
            try {
                barbarian.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 20; i++) {
                int defendValue = barbarian.defend();
                assertTrue(defendValue <= 20 && defendValue >= 0);
                try {
                    barbarian.setHealth((int) (barbarian.getHealth() * 0.95));
                } catch (IllegalHealthAssignmentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void special() {
        for(int i = 0; i < 100; i++) {
            try {
                barbarian.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int j = 0; j < 20; j++) {
                int[] specialValues = barbarian.special();
                assertTrue(specialValues[0] > 0 && specialValues[0] <= 20 &&
                        specialValues[1] > 0 && specialValues[1] <= 20);
                try {
                    barbarian.setHealth((int) (barbarian.getHealth() * 0.95));
                } catch (IllegalHealthAssignmentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}