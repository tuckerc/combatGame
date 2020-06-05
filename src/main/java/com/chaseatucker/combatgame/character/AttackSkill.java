package com.chaseatucker.combatgame.character;

/**
 * AttackSkill enum for use of Character class.
 */
public enum AttackSkill {
    SLASH(25),
    PIERCE(25),
    BLUDGEON(25),
    POISON(30),
    ACID_SPRAY(30),
    FIREBALL(30),
    FREEZE(20),
    SHOCK(25);

    private int attackStrength;

    /**
     * AttackSkill constructor.
     * @param attackStrength AttackSkill strength
     */
    private AttackSkill(int attackStrength) {
        this.setAttackStrength(attackStrength);
    }

    /**
     * Getter for AttackSkill strength.
     * @return AttackSkill strength
     */
    public int getAttackStrength() {
        return attackStrength;
    }

    /**
     * Setter for AttackSkill strength.
     * @param attackStrength AttackSkill strength
     */
    private void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    /**
     * toString() override for AttackStrength enum.
     * @return String representation of AttackStrength
     */
    @Override
    public String toString() {
        return "AttackSkill{" +
                "name=" + this.name() +
                ", attackStrength=" + this.attackStrength +
                '}';
    }
}
