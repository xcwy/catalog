package io.rai.catalog.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "r_category")
public class Category {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The Name.
     */
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    /**
     * The Description.
     */
    @Column(name = "description", length = 1024)
    private String description;

    /**
     * The Depth.
     */
    @Column(name = "depth")
    private int depth;

    /**
     * The Sub categories.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> subCategories;

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     *
     * @param name        the name
     * @param description the description
     * @param depth       the depth
     */
    public Category(String name, String description, int depth) {

        this.name = name;
        this.description = description;
        this.depth = depth;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {

        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets depth.
     *
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Sets depth.
     *
     * @param depth the depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Gets sub categories.
     *
     * @return the sub categories
     */
    public Set<Category> getSubCategories() {
        return subCategories;
    }

    /**
     * Sets sub categories.
     *
     * @param subCategories the sub categories
     */
    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    /**
     * Add sub category.
     *
     * @param subCategory the sub category
     */
    public void addSubCategory(Category subCategory) {
        if (this.subCategories == null) {
            this.subCategories = new HashSet<>();
        }
        this.subCategories.add(subCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (depth != category.depth) return false;
        if (!name.equals(category.name)) return false;
        return description != null ? description.equals(category.description) : category.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + depth;
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", depth=" + depth +
                '}';
    }
}
