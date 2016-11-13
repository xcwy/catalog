package io.rai.catalog.service

import io.rai.catalog.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rai on 16/11/13.
 */
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class CategoryServiceUpdateTest extends Specification{
    @Autowired
    private CategoryService cs

    def "test 1 : update category name"() {
        given:
        def id = 1
        def name = "computers"

        when:
        cs.editCategoryName(id, name)

        then:
        true
    }

    def "test 2 : update category description"() {
        given:
        def id = 1
        def description = "this is computers category"

        when:
        def c = cs.editCategoryDescription(id, description)

        then:
        true
    }
}
