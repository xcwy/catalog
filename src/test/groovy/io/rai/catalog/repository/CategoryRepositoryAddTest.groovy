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
class CategoryRepositoryAddTest extends Specification{
    @Autowired
    private CategoryRepository cr

    /*
    添加顶层目录比较简单，不需要做任何处理
     */
    def "test 1 : add Top Category"() {
        given:
        def name = "books"
        def depth = 0
        def description = "this is books category"
        def c = new Category(name, description, depth)

        when:
        def savedCategory = cr.save(c)

        then:
        savedCategory != null
        savedCategory.id > 0
        savedCategory.name == name
        savedCategory.depth == depth
        savedCategory.description == description
        /*
         Hibernate: insert into r_category (depth, description, name) values (?, ?, ?)
         */
    }

    /*
    添加子目录比较麻烦，有两种方式可以使用：
    1. 添加子目录到父目录的列表中，保存父目录
    2. 保存子目录，然后添加到父目录的列表中，保存父目录

     */
    def "test 2 : add subCategory to Top Category"() {
        given:
        def parentId = 1
        def name = "novel"
        def depth = 1
        def description = "this is novel books category"


    }

    def "test 3 : add 3g Category to 2g Category"() {

    }
}
