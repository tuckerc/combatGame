package com.chaseatucker.combatgame.character;

public class Wizard extends Character{

    public Wizard(String weapon, String name, int attackPoints, int defendPoints) throws IllegalPointAssignmentException, IllegalHealthAssignmentException {
        super(weapon, name, attackPoints, defendPoints);
        this.getAttackSkills().add(AttackSkill.ACID_SPRAY);
        this.getAttackSkills().add(AttackSkill.FREEZE);
        this.getAttackSkills().add(AttackSkill.FIREBALL);
        this.getAttackSkills().add(AttackSkill.SHOCK);
        this.getDefendSkills().add(DefendSkill.CLOAK);
        this.getDefendSkills().add(DefendSkill.TELEPORT);
    }

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
