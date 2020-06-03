package com.chaseatucker.combatgame.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackSkillTest {

    AttackSkill attackSkill;

    @Before
    public void setUp() throws Exception {
        attackSkill = AttackSkill.ACID_SPRAY;
    }

    @Test
    public void getAttackStrength() {
        assertEquals(20, attackSkill.getAttackStrength());
    }

    @Test
    public void getDefendStrength() {
        assertEquals(0, attackSkill.getDefendStrength());
    }
}