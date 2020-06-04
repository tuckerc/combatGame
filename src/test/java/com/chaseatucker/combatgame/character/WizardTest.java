package com.chaseatucker.combatgame.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WizardTest {

    Wizard wizard;

    @Before
    public void setUp() throws Exception {
        wizard = new Wizard("staff", "Gandoff");
    }

    @Test
    public void attack() {
        for(int j = 0; j < 100; j++) {
            try {
                wizard.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 20; i++) {
                int attackValue = wizard.attack();
                assertTrue(attackValue <= 20 && attackValue >= 0);
                try {
                    wizard.setHealth((int) (wizard.getHealth() * 0.95));
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
                wizard.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 20; i++) {
                int defendValue = wizard.defend();
                assertTrue(defendValue <= 20 && defendValue >= 0);
                try {
                    wizard.setHealth((int) (wizard.getHealth() * 0.95));
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
                wizard.setHealth(100);
            } catch (IllegalHealthAssignmentException e) {
                e.printStackTrace();
            }
            for(int j = 0; j < 20; j++) {
                int[] specialValues = wizard.special();
                assertTrue(specialValues[0] > 0 && specialValues[0] <= 20 &&
                        specialValues[1] > 0 && specialValues[1] <= 20);
                try {
                    wizard.setHealth((int) (wizard.getHealth() * 0.95));
                } catch (IllegalHealthAssignmentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}