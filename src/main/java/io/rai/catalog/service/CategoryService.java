package io.rai.catalog.service;

import io.rai.catalog.entity.Category;
import io.rai.catalog.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rai on 16/11/13.
 */
@Service
public class CategoryService {
    /**
     * log.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Save top category category.
     *
     * @param name        the name
     * @param description the description
     * @return the category
     */
    public Category saveTopCategory(String name, String description) {
        final int depth = 0;
        Category category = new Category(name, description, depth);
        return categoryRepository.save(category);
    }

    /**
     * Save sub category category.
     *
     * @param parentId    the parent id
     * @param name        the name
     * @param description the description
     * @return the category
     */
    public Category saveSubCategory(int parentId, String name, String description) {
        Category parent = categoryRepository.findOne(parentId);
        LOG.debug("find parent {}", parent.toString());
        final int subCategoryDepth = parent.getDepth() + 1;
        LOG.debug("set subCategory depth {}", subCategoryDepth);
        Category subCategory = new Category(name, description, subCategoryDepth);
        LOG.debug("new subCategory {}", subCategory.toString());
        categoryRepository.save(subCategory);
        LOG.debug("save subCategory");
        parent.addSubCategory(subCategory);
        LOG.debug("add subCategory");
        categoryRepository.save(parent);
        LOG.debug("save parent");
        return subCategory;
    }

    /**
     * Edit category name.
     *
     * @param id   the id
     * @param name the name
     */
    public void editCategoryName(int id, String name) {
        LOG.debug("enter editCategoryName, id is {}, name is {}", id, name);
        categoryRepository.editCategoryName(id, name);
        LOG.debug("end editCategoryName");
    }

    /**
     * Edit category description.
     *
     * @param id          the id
     * @param desctiption the desctiption
     */
    public void editCategoryDescription(int id, String desctiption) {
        LOG.debug("enter editCategoryDescription, id is {}, description is {}", id, desctiption);
        categoryRepository.editCategoryDescription(id, desctiption);
        LOG.debug("end editCategoryDescription");
    }
}
