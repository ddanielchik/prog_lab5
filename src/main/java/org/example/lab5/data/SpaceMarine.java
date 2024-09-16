package org.example.lab5.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

/**
 * Класс, представляющий космического морпеха.
 * Реализует интерфейс Comparable для сравнения космических морпехов по расстоянию от начала координат.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpaceMarine implements Comparable<SpaceMarine> {
    private Long id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно быть генерироваться автоматически

    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null

    private java.time.ZonedDateTime creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private long health; // Значение поля должно быть больше 0
    private AstartesCategory category; // Поле не может быть null
    private Weapon weaponType; // Поле может быть null
    private MeleeWeapon meleeWeapon; // Поле может быть null
    private Chapter chapter; // Поле не может быть null

    /**
     * Конструктор по умолчанию.
     */
    public SpaceMarine() {}

    /**
     * Конструктор с параметрами.
     *
     * @param id уникальный идентификатор космического морпеха
     * @param name имя космического морпеха
     * @param coordinates координаты космического морпеха
     * @param creationDate дата создания космического морпеха
     * @param health здоровье космического морпеха
     * @param category категория космического морпеха
     * @param weaponType тип оружия
     * @param meleeWeapon тип ближнего оружия
     * @param chapter глава космического морпеха
     */
    public SpaceMarine(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, long health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate; // не забыть написать реализацию текущего времени
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    /**
     * Конструктор с параметрами без идентификатора.
     *
     * @param name имя космического морпеха
     * @param coordinates координаты космического морпеха
     * @param health здоровье космического морпеха
     * @param category категория космического морпеха
     * @param weaponType тип оружия
     * @param meleeWeapon тип ближнего оружия
     * @param chapter глава космического морпеха
     */
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

    /**
     * Устанавливает дату создания космического морпеха на текущее время.
     */
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

    /**
     * Проверяет валидность космического морпеха.
     *
     * @return true, если космический морпех валиден, иначе false
     */
    public boolean validate() {
        if (this.getChapter() == null) return false;
        if (this.getCoordinates() == null) return false;
        if (this.getHealth() < 0) return false;
        return true;
    }

    /**
     * Возвращает строковое представление космического морпеха.
     *
     * @return строка с информацией о космическом морпехе
     */
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
                + "world: " + chapter.getWorld() + "\n-------------------\n";
        // лучше переделать под форматированный вывод и выводить в виде таблицы (будет круто выглядеть, но может быть запарно)
    }

    /**
     * Сравнивает текущий космический морпех с другим по расстоянию от начала координат.
     *
     * @param o другой космический морпех для сравнения
     * @return отрицательное число, если текущий морпех ближе, положительное, если дальше, и 0, если на одинаковом расстоянии
     */
    @Override
    public int compareTo(SpaceMarine o) {
        double thisDistance = Math.sqrt(Math.pow(this.getCoordinates().getX(), 2) + Math.pow(this.getCoordinates().getY(), 2));
        double otherDistance = Math.sqrt(Math.pow(o.getCoordinates().getX(), 2) + Math.pow(o.getCoordinates().getY(), 2));
        return Double.compare(thisDistance, otherDistance);
    }
}
