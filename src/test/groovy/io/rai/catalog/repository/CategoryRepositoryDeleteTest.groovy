package io.rai.catalog.repository

import io.rai.catalog.Application
import io.rai.catalog.entity.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rai on 16/11/13.
 */
@ContextConfiguration(classes = Application.class,loader = SpringBootContextLoader.class)
class CategoryRepositoryDeleteTest extends Specification{
    @Autowired
    private CategoryRepository cr

    def "test 1 : use @Query to delete subCategory relationship"() {
        given:
        def id = 3

        when:
        cr.deleteSucCategoryRelationship(id)

        then:
        true
    }

    def "test 2 : delete subCategory"() {
        given:
        def id = 3

        when:
        cr.delete(id)

        then:
        true
    }
}
