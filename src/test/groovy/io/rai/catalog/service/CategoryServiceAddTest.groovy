package io.rai.catalog.service

import ch.qos.logback.core.util.Loader
import io.rai.catalog.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rai on 16/11/13.
 */
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class CategoryServiceAddTest extends Specification{
    @Autowired
    private CategoryService cs

    def "test 1 : add top category"() {
        given:
        def name = "computer"
        def description = "this is computer category"

        when:
        def c = cs.saveTopCategory(name, description)

        then:
        c != null
        c.id > 0
        c.name == name
        c.description == description
    }

    def "test 2 : add sub category"() {
        given:
        def parentId = 1
        def name = "new new new laptop"
        def description = "this is new new new laptop category"

        when:
        def c = cs.saveSubCategory(parentId, name, description)

        then:
        c != null
        c.id > 0
        c.name == name
        c.description == description
    }

    def "test 3 : add sub category to sub category"() {
        given:
        def parentId = 2
        def name = "thin notebook"
        def description = "this is thin notbook category"

        when:
        def c = cs.saveSubCategory(parentId, name, description)

        then:
        c != null
        c.id > 0
        c.name == name
        c.description == description
    }
}
