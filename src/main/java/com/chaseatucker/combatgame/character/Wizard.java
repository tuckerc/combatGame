package com.chaseatucker.combatgame.character;

/**
 * Wizard subclass of Character
 */
public class Wizard extends Character{

    /**
     * Wizard constructor
     * @param weapon Wizard's primary weapon
     * @param name Wizard's name
     * @throws IllegalHealthAssignmentException health must be greater than MIN_HEALTH
     */
    public Wizard(String weapon, String name) throws IllegalHealthAssignmentException {
        super(weapon, name);
        this.getAttackSkills().add(AttackSkill.ACID_SPRAY);
        this.getAttackSkills().add(AttackSkill.FREEZE);
        this.getAttackSkills().add(AttackSkill.FIREBALL);
        this.getAttackSkills().add(AttackSkill.SHOCK);
        this.getDefendSkills().add(DefendSkill.CLOAK);
        this.getDefendSkills().add(DefendSkill.TELEPORT);
    }

    /**
     * Wizard's attack method.
     * @return attack strength
     */
    @Override
    public int attack() {
        int index = (int) (Math.random() * this.getAttackSkills().size());
        AttackSkill attackSkill = this.getAttackSkills().get(index);
        int attackStrength = attackSkill.getAttackStrength() * fatigueStrength();
        System.out.println(this.getName() + "(" + this.getClass().getSimpleName() + ")" +
                " attacks with " + attackSkill.name() + " with " + attackStrength +
                " points of damage.");
        return attackStrength;
    }

    /**
     * toString() override for the Wizard class.
     * @return String representation of the wi
     */
    @Override
    public int defend() {
        int index = (int) (Math.random() * this.getDefendSkills().size());
        DefendSkill defendSkill = this.getDefendSkills().get(index);
        int defendStrength = defendSkill.getDefendStrength() * fatigueStrength();
        System.out.println(this.getName() + "(" + this.getClass().getSimpleName() + ")" +
                " defends with " + defendSkill.name() + " with " + defendStrength +
                " defense points.");
        return defendStrength;
    }

    @Override
    public int[] special() {
        return new int[] {this.attack(), this.defend()};
    }

    private int fatigueStrength() {
        return (int) Math.round(this.getHealth() * 0.7);
    }
}