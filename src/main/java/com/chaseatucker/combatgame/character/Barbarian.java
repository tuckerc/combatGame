package com.chaseatucker.combatgame.character;

/**
 * Barbarian subclass of Character
 */
public class Barbarian extends Character{

    /**
     * Barbarian constructor
     * @param weapon Barbarian's primary weapon
     * @param name Barbarian's name
     * @throws IllegalHealthAssignmentException health must be greater than MIN_HEALTH
     */
    public Barbarian(String weapon, String name) throws IllegalHealthAssignmentException {
        super(weapon, name);
        this.getAttackSkills().add(AttackSkill.SLASH);
        this.getAttackSkills().add(AttackSkill.PIERCE);
        this.getAttackSkills().add(AttackSkill.BLUDGEON);
        this.getDefendSkills().add(DefendSkill.BLOCK);
        this.getDefendSkills().add(DefendSkill.SHIELD);
    }

    /**
     * Barbarian's attack method.
     * @return attack strength
     */
    @Override
    public int attack() {
        int index = (int) (Math.random() * this.getAttackSkills().size());
        AttackSkill attackSkill = this.getAttackSkills().get(index);
        int attackStrength = attackSkill.getAttackStrength() - fatigueStrength();
        System.out.println(this.getName() + " (" + this.getClass().getSimpleName() + ")" +
                " attacks with " + attackSkill.name() + " with " + attackStrength +
                " points of damage.");
        return attackStrength;
    }

    /**
     * Barbarian defend method.
     * @return Defend strength
     */
    @Override
    public int defend() {
        int index = (int) (Math.random() * this.getDefendSkills().size());
        DefendSkill defendSkill = this.getDefendSkills().get(index);
        int defendStrength = defendSkill.getDefendStrength() - fatigueStrength();
        System.out.println(this.getName() + " (" + this.getClass().getSimpleName() + ")" +
                " defends with " + defendSkill.name() + " with " + defendStrength +
                " defense points.");
        return defendStrength;
    }

    /**
     * Barbarian special move method.
     * @return int[] with index 0 being attack value and index 1 being defend value.
     */
    @Override
    public int[] special() {
        return new int[] {this.attack(), this.defend()};
    }

    /**
     * Private method to determine how much fatigue effects attack and defend effectiveness.
     * @return
     */
    private int fatigueStrength() {
        return (int) Math.round(Math.floor((100 - this.getHealth()) * 0.09));
    }
}
