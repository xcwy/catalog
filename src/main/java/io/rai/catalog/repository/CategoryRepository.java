package io.rai.catalog.repository;

import io.rai.catalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rai on 16/11/13.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Transactional
    @Modifying
    @Query("update Category c set c.name = ?2 where c.id = ?1")
    void editCategoryName(int id, String name);

    @Transactional
    @Modifying
    @Query("update Category c set c.description = ?2 where c.id = ?1")
    void editCategoryDescription(int id, String description);

    @Transactional
    @Modifying
    @Query(value = "delete from r_category_sub_categories where sub_categories_id = ?1", nativeQuery = true)
    void deleteSucCategoryRelationship(int id);
}

