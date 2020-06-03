package com.chaseatucker.combatgame.character;

public enum DefendSkill {
    SHIELD(20),
    TELEPORT(20),
    CLOAK(15),
    BLOCK(10);

    private int defendStrength;

    private DefendSkill(int defendStrength) {
        this.setDefendStrength(defendStrength);
    }

    public int getDefendStrength() {
        return defendStrength;
    }

    private void setDefendStrength(int defendStrength) {
        this.defendStrength = defendStrength;
    }
}
