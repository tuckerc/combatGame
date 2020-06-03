package com.chaseatucker.combatgame.character;

public enum AttackSkill {
    SLASH(10),
    PIERCE(10),
    BLUDGEON(15),
    POISON(20),
    ACID_SPRAY(20),
    FIREBALL(20),
    FREEZE(10),
    SHOCK(15);

    private int attackStrength;

    private AttackSkill(int attackStrength) {
        this.setAttackStrength(attackStrength);
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    private void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }
}
