package com.chaseatucker.combatgame.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackSkillTest {

    AttackSkill acidAttackSkill;
    AttackSkill slashAttackSkill;

    @Before
    public void setUp() throws Exception {
        acidAttackSkill = AttackSkill.ACID_SPRAY;
        slashAttackSkill = AttackSkill.SLASH;
    }

    @Test
    public void getAttackStrength() {
        assertEquals(20, acidAttackSkill.getAttackStrength());
        assertEquals(10, slashAttackSkill.getAttackStrength());
    }

    @Test
    public void testToString() {
        assertEquals("AttackSkill{name=ACID_SPRAY, attackStrength=20}",
                acidAttackSkill.toString());
        assertEquals("AttackSkill{name=SLASH, attackStrength=10}",
                slashAttackSkill.toString());
    }
}