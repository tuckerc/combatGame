package com.chaseatucker.combatgame.character;

/**
 * AttackSkill enum for use of Character class.
 */
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
