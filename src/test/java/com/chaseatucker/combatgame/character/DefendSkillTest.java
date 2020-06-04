package com.chaseatucker.combatgame.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefendSkillTest {

    DefendSkill blockDefendSkill;
    DefendSkill teleportDefendSkill;

    @Before
    public void setup() throws Exception {
        blockDefendSkill = DefendSkill.BLOCK;
        teleportDefendSkill = DefendSkill.TELEPORT;
    }

    @Test
    public void getDefendStrength() {
        assertEquals(10, blockDefendSkill.getDefendStrength());
        assertEquals(20, teleportDefendSkill.getDefendStrength());
    }

    @Test
    public void testToString() {
        assertEquals("DefendSkill{name=BLOCK, defendStrength=10}",
                blockDefendSkill.toString());
        assertEquals("DefendSkill{name=TELEPORT, defendStrength=20}",
                teleportDefendSkill.toString());
    }
}