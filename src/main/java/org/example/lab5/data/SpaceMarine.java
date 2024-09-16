package org.example.lab5.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class SpaceMarine implements Comparable<SpaceMarine>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически


    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private long health; //Значение поля должно быть больше 0
    private AstartesCategory category; //Поле не может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null


    public SpaceMarine() {}

    public SpaceMarine(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, long health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;//не забыть написать реализацию текущего времени
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public SpaceMarine(String name, Coordinates coordinates, long health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = 1L;
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
        setCreationDate();
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @JsonProperty("creationDate")
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate() {
        this.creationDate = ZonedDateTime.now();
    }
    @JsonProperty("health")
    public long getHealth() {
        return health;
    }
    @JsonProperty("category")
    public AstartesCategory getCategory() {
        return category;
    }
    @JsonProperty("weapon type")
    public Weapon getWeaponType() {
        return weaponType;
    }
    @JsonProperty("melee weapon")
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }
    @JsonProperty("chapter")
    public Chapter getChapter() {
        return chapter;
    }

    public boolean validate()
    {
        if(this.getChapter() == null ) return false;
        if(this.getCoordinates() == null) return false;
        if(this.getHealth() < 0) return false;
        return true;
    }



    public String toString() {
        return "\n-------------------\n"
                + "id: " + id + "\n"
                + "name: " + name
                + "\n-------------------\n"
                + "Coordinates " + "\n-------------------\n"
                + "y: " + coordinates.getY() + "\n"
                + "x: " + coordinates.getX() + "\n-------------------\n"
                + "creation date: " + creationDate.toString() + "\n"
                + "health: " + health + "\n"
                + "ctagory: " + category.toString() + "\n"
                + "weapon type: " + weaponType.toString() + "\n"
                + "melee weapon type: " + meleeWeapon.toString()
                + "\n-------------------\n"
                + "Chapter" + "\n-------------------\n"
                + "name: " + chapter.getName() + "\n"
                + "parent legion: " + chapter.getParentLegion() + "\n"
                + "marines count: " + chapter.getMarinesCount() + "\n"
                + "world: " + chapter.getWorld() +"\n-------------------\n";
    //лучше переделать под форматированный вывод и выводить в виде таблицы (будет круто выглядеть, но может быть запарно)
    }

    @Override
    public int compareTo(SpaceMarine o) {
        double thisDistance = Math.sqrt(Math.pow(this.getCoordinates().getX(), 2) + Math.pow(this.getCoordinates().getY(), 2));
        double otherDistance = Math.sqrt(Math.pow(o.getCoordinates().getX(), 2) + Math.pow(o.getCoordinates().getY(), 2));
        return Double.compare(thisDistance, otherDistance);
    }
}
