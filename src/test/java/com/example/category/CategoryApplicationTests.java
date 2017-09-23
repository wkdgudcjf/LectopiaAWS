package com.example.category;

import com.example.category.entity.Category;
import com.example.category.entity.Test1;
import com.example.category.entity.Test2;
import com.example.category.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class CategoryApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryComponentRepository categoryComponentRepository;

	@Autowired
	private CategoryCompositeRepository categoryCompositeRepository;

	@Autowired
	private CategoryLeafRepository categoryLeafRepository;

	@Autowired
	private Test1Repository test1Repository;

	@Autowired
	private Test2Repository test2Repository;

	@Test
	@Transactional
	public void 테스트1() {
//		String name = "category3";
//		Category category = categoryRepository.findByName(name);
//
//		Assert.assertTrue(name.equals(category.getName()));
	}

	@Test
	@Transactional
	public void 테스트2() {
//		String name = "categoryComposite1";
//		CategoryComponent categoryComponent = categoryComponentRepository.find(name);
//
//		Assert.assertTrue(name.equals(categoryComponent.getName()));
	}

	@Test
	@Transactional
	public void 테스트3() {
//		String name = "categoryComposite1";
//		CategoryComposite categoryComponent = categoryCompositeRepository.findByName(name);
//
//		Assert.assertTrue(name.equals(categoryComponent.getName()));
	}

	@Test
	@Transactional
	public void 테스트4() {
//		String name = "categoryLeaf1";
//		CategoryLeaf categoryLeaf = categoryLeafRepository.findByName(name);
//
//		Assert.assertTrue(name.equals(categoryLeaf.getName()));
	}

	@Test
	public void 테스트5() {
//		Test1 test1 = new Test1();
//		Test2 test2 = new Test2();
//		test1.setTest2List(Arrays.asList(test2));
//		test2Repository.save(test2);
//		test1Repository.save(test1);
//
//		System.out.println("TEST");
	}

	@Test
	@Transactional
	public void 테스트() {
//		Category category = new Category();
//		category.setName("category7");
//		categoryRepository.save(category);
	}

}