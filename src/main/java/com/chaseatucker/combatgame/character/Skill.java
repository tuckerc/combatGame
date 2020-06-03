package com.chaseatucker.combatgame.character;

public enum Skill {
    SLASH(10, 0),
    PIERCE(10,0),
    BLUDGEON(15,0),
    POISON(20,-5),
    ACID_SPRAY(20,0),
    FIREBALL(20,0),
    FREEZE(10,10),
    SHOCK(15,0),
    SHIELD(0, 20),
    TELEPORT(0, 20),
    CLOAK(0, 15),
    BLOCK(0, 10);

    private int attackStrength;
    private int defendStrength;

    private Skill(int attackStrength, int defendStrength) {
        this.setAttackStrength(attackStrength);
        this.setDefendStrength(defendStrength);
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDefendStrength() {
        return defendStrength;
    }

    public void setDefendStrength(int defendStrength) {
        this.defendStrength = defendStrength;
    }
}
