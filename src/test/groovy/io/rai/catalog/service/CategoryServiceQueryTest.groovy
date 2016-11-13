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
class CategoryServiceQueryTest extends Specification{
    @Autowired
    private CategoryService cs

    def "test 1 : use jpa method to query category by id"() {
        given:
        def id = 1

        when:
        def c = cs.findCategoryById(id)

        then:
        c != null
        c.id == id
        c.name != null
        c.name != ""
        /*
        成功，非常恐怖，每个subCategory都重新查询了一次
        Hibernate: select category0_.id as id1_0_0_, category0_.depth as depth2_0_0_, category0_.description as descript3_0_0_, category0_.name as name4_0_0_, subcategor1_.category_id as category1_1_1_, category2_.id as sub_cate2_1_1_, category2_.id as id1_0_2_, category2_.depth as depth2_0_2_, category2_.description as descript3_0_2_, category2_.name as name4_0_2_ from r_category category0_ left outer join r_category_sub_categories subcategor1_ on category0_.id=subcategor1_.category_id left outer join r_category category2_ on subcategor1_.sub_categories_id=category2_.id where category0_.id=?
        Hibernate: select subcategor0_.category_id as category1_1_0_, subcategor0_.sub_categories_id as sub_cate2_1_0_, category1_.id as id1_0_1_, category1_.depth as depth2_0_1_, category1_.description as descript3_0_1_, category1_.name as name4_0_1_ from r_category_sub_categories subcategor0_ inner join r_category category1_ on subcategor0_.sub_categories_id=category1_.id where subcategor0_.category_id=?
        Hibernate: select subcategor0_.category_id as category1_1_0_, subcategor0_.sub_categories_id as sub_cate2_1_0_, category1_.id as id1_0_1_, category1_.depth as depth2_0_1_, category1_.description as descript3_0_1_, category1_.name as name4_0_1_ from r_category_sub_categories subcategor0_ inner join r_category category1_ on subcategor0_.sub_categories_id=category1_.id where subcategor0_.category_id=?
        Hibernate: select subcategor0_.category_id as category1_1_0_, subcategor0_.sub_categories_id as sub_cate2_1_0_, category1_.id as id1_0_1_, category1_.depth as depth2_0_1_, category1_.description as descript3_0_1_, category1_.name as name4_0_1_ from r_category_sub_categories subcategor0_ inner join r_category category1_ on subcategor0_.sub_categories_id=category1_.id where subcategor0_.category_id=?
        Hibernate: select subcategor0_.category_id as category1_1_0_, subcategor0_.sub_categories_id as sub_cate2_1_0_, category1_.id as id1_0_1_, category1_.depth as depth2_0_1_, category1_.description as descript3_0_1_, category1_.name as name4_0_1_ from r_category_sub_categories subcategor0_ inner join r_category category1_ on subcategor0_.sub_categories_id=category1_.id where subcategor0_.category_id=?
        Hibernate: select subcategor0_.category_id as category1_1_0_, subcategor0_.sub_categories_id as sub_cate2_1_0_, category1_.id as id1_0_1_, category1_.depth as depth2_0_1_, category1_.description as descript3_0_1_, category1_.name as name4_0_1_ from r_category_sub_categories subcategor0_ inner join r_category category1_ on subcategor0_.sub_categories_id=category1_.id where subcategor0_.category_id=?
         */
    }
}
