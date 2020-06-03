package com.chaseatucker.combatgame.character;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Abstract Character Class for Combat Game
 * @author Chase Tucker
 * @version 1.0 June 2, 2020
 */
public abstract class Character {
    // Class constants
    public static final int MIN_POINTS = 0;
    public static final int MIN_HEALTH = 0;

    // Instance variables
    private String weapon;
    private String name;
    private ArrayList<AttackSkill> attackSkills;
    private ArrayList<DefendSkill> defendSkills;
    private int attackPoints;
    private int defendPoints;
    private int health;

    /**
     * Character constructor
     * @param weapon Character's primary weapon
     * @param name Character's name
     * @param attackPoints Character's attack points
     * @param defendPoints Character's defend points
     * @throws IllegalPointAssignmentException attack and defend points must be grater than MIN_POINTS.
     * @throws IllegalHealthAssignmentException health value must be greater than MIN_HEALTH.
     */
    public Character(String weapon, String name, int attackPoints, int defendPoints) throws IllegalPointAssignmentException, IllegalHealthAssignmentException {
        this.setWeapon(weapon);
        this.setName(name);
        this.attackSkills = new ArrayList<>();
        this.defendSkills = new ArrayList<>();
        this.setAttackPoints(attackPoints);
        this.setDefendPoints(defendPoints);
        this.setHealth(100);
    }

    /**
     * Getter for Character's primary weapon.
     * @return Character's primary weapon
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * Setter for Character's primary weapon.
     * @param weapon Character's primary weapon
     */
    private void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    /**
     * Getter for Character's name.
     * @return Character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for Character's name.
     * @param name Character's name
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for Character's attackSkills.
     * @return Set of Character's attackSkills
     */
    public ArrayList<AttackSkill> getAttackSkills() {
        return attackSkills;
    }

    /**
     * Getter for Character's defendSkills.
     * @return Set of Character's defendSkills
     */
    public ArrayList<DefendSkill> getDefendSkills() {
        return defendSkills;
    }

    /**
     * Getter for Character's attack points.
     * @return Character's attack points
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Setter for Character's attack points.
     * @param attackPoints Character's attack points
     * @throws IllegalPointAssignmentException attack points must be greater than MIN_POINTS.
     */
    public void setAttackPoints(int attackPoints) throws IllegalPointAssignmentException {
        if(attackPoints < MIN_POINTS) {
            throw new IllegalPointAssignmentException("attack points must be greater than " +
                    MIN_POINTS);
        }
        this.attackPoints = attackPoints;
    }

    /**
     * Getter for Character's defend points.
     * @return Character's defend points
     */
    public int getDefendPoints() {
        return defendPoints;
    }

    /**
     * Setter for Character's defnd points.
     * @param defendPoints Character's defend points
     * @throws IllegalPointAssignmentException defend points must be greater than MIN_POINTS.
     */
    public void setDefendPoints(int defendPoints) throws IllegalPointAssignmentException {
        if(defendPoints < MIN_POINTS) {
            throw new IllegalPointAssignmentException("defend points must be greater than " +
                    MIN_POINTS);
        }
        this.defendPoints = defendPoints;
    }

    /**
     * Getter for Character's health.
     * @return Character's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter for Character's health.
     * @param health Character's health
     * @throws IllegalHealthAssignmentException Character's health must be greater than MIN_HEALTH
     */
    public void setHealth(int health) throws IllegalHealthAssignmentException {
        if(health < MIN_HEALTH) {
            throw new IllegalHealthAssignmentException("health must be greater than " +
                    MIN_HEALTH);
        }
        this.health = health;
    }

    /**
     * Abstract Character attack method to be implemented by inheriting Class.
     * @return Character attack value
     */
    public abstract int attack();

    /**
     * Abstract Character defend method to be implemented by the inheriting Class.
     * @return Character defense value
     */
    public abstract int defend();

    /**
     * Abstract Character special move method to be implemented by the inheriting Class.
     * @return Character attack and defense values from special move
     */
    public abstract int[] special();

    /**
     * toString() override for Character Class.
     * @return String representation of Character object
     */
    @Override
    public String toString() {
        return "Character{" +
                "weapon='" + weapon + '\'' +
                ", name='" + name + '\'' +
                ", attackSkills=" + attackSkills +
                ", attackPoints=" + attackPoints +
                ", defendPoints=" + defendPoints +
                ", health=" + health +
                '}';
    }

    /**
     * equals() override for Character Class.
     * @param o object for equality comparison
     * @return true if equal, false if not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return getAttackPoints() == character.getAttackPoints() &&
                getDefendPoints() == character.getDefendPoints() &&
                getHealth() == character.getHealth() &&
                getWeapon().equals(character.getWeapon()) &&
                getName().equals(character.getName()) &&
                getAttackSkills().equals(character.getAttackSkills());
    }

    /**
     * hashCode() override for Character Class.
     * @return hash of Character instance variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWeapon(), getName(), getAttackSkills(),
                getAttackPoints(), getDefendPoints(), getHealth());
    }
}
