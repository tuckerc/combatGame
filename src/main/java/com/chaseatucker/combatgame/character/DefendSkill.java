package com.chaseatucker.combatgame.character;

public enum DefendSkill {
    SHIELD(20),
    TELEPORT(20),
    CLOAK(15),
    BLOCK(15);

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

    @Override
    public String toString() {
        return "DefendSkill{" +
                "name=" + this.name() +
                ", defendStrength=" + defendStrength +
                '}';
    }
}
