package io.rai.catalog.service

import io.rai.catalog.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.swing.plaf.TreeUI

/**
 * Created by rai on 16/11/13.
 */
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class CategoryServiceDeleteTest extends Specification {
    @Autowired
    private CategoryService cs

    def "test 1 : delete top category by id"() {
        given:
        def id = 1

        when:
        cs.deletCategoryById(id)

        then:
        true
    }

    def "test 2 : delete subCategory by id"() {
        given:
        def id = 2

        when:
        cs.deletCategoryById(id)

        then:
        true
    }
}
