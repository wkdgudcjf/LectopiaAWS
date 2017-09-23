package com.example.category;

import com.example.category.entity.Category;
import com.example.category.entity.CategoryComponent;
import com.example.category.entity.CategoryComposite;
import com.example.category.entity.CategoryLeaf;
import com.example.category.repository.CategoryComponentRepository;
import com.example.category.repository.CategoryCompositeRepository;
import com.example.category.repository.CategoryLeafRepository;
import com.example.category.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryComponentRepository categoryComponentRepository;

	@Autowired
	private CategoryCompositeRepository categoryCompositeRepository;

	@Autowired
	private CategoryLeafRepository categoryLeafRepository;

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

}
