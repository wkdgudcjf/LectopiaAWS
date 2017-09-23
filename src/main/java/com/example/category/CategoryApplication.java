package com.example.category;

import com.example.category.entity.Category;
import com.example.category.entity.CategoryComponent;
import com.example.category.entity.CategoryComposite;
import com.example.category.entity.CategoryLeaf;
import com.example.category.repository.CategoryComponentRepository;
import com.example.category.repository.CategoryRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class CategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryComponentRepository categoryComponentRepository;

	@Bean
	@Transactional
	public InitializingBean localInitializingBean() {
		return () -> {
			Category category1 = new Category();
			category1.setName("category1");
			Category category2 = new Category();
			category2.setName("category2");
			Category category3 = new Category();
			category3.setName("category3");

			Category category31 = new Category();
			category31.setName("category31");
			Category category32 = new Category();
			category32.setName("category32");
			Category category33 = new Category();
			category33.setName("category33");
			Category category34 = new Category();
			category34.setName("category34");
			Category category35 = new Category();
			category35.setName("category35");
			Category category36 = new Category();
			category36.setName("category36");
			Category category37 = new Category();
			category37.setName("category37");

			Category category4 = new Category();
			category4.setName("category4");
			Category category5 = new Category();
			category5.setName("category5");
			categoryRepository.save(category5);
			category4.setParent(category5);
			categoryRepository.save(category4);
			category3.setParent(category4);
			categoryRepository.save(category3);

			category31.setParent(category4);
			categoryRepository.save(category31);
			category32.setParent(category4);
			categoryRepository.save(category32);
			category33.setParent(category4);
			categoryRepository.save(category33);
			category34.setParent(category4);
			categoryRepository.save(category34);
			category35.setParent(category4);
			categoryRepository.save(category35);
			category36.setParent(category4);
			categoryRepository.save(category36);
			category37.setParent(category4);
			categoryRepository.save(category37);

			category2.setParent(category3);
			categoryRepository.save(category2);
			category1.setParent(category2);
			categoryRepository.save(category1);

			/*****************************************************************/
			/*****************************************************************/
			/*****************************************************************/

			CategoryComponent categoryComposite1 = new CategoryComposite();
			categoryComposite1.setName("categoryComposite1");
			CategoryComponent categoryComposite2 = new CategoryComposite();
			categoryComposite2.setName("categoryComposite2");
			CategoryComponent categoryLeaf1 = new CategoryLeaf();
			categoryLeaf1.setName("categoryLeaf1");
			categoryLeaf1.setParent(categoryComposite1);
			CategoryComponent categoryLeaf2 = new CategoryLeaf();
			categoryLeaf2.setName("categoryLeaf2");
			categoryLeaf2.setParent(categoryComposite1);
			CategoryComponent categoryLeaf3 = new CategoryLeaf();
			categoryLeaf3.setName("categoryLeaf3");
			categoryLeaf3.setParent(categoryComposite2);

			CategoryComponent categoryLeaf31 = new CategoryLeaf();
			categoryLeaf31.setName("categoryLeaf31");
			categoryLeaf31.setParent(categoryComposite2);
			CategoryComponent categoryLeaf32 = new CategoryLeaf();
			categoryLeaf32.setName("categoryLeaf32");
			categoryLeaf32.setParent(categoryComposite2);
			CategoryComponent categoryLeaf33 = new CategoryLeaf();
			categoryLeaf33.setName("categoryLeaf33");
			categoryLeaf33.setParent(categoryComposite2);
			CategoryComponent categoryLeaf34 = new CategoryLeaf();
			categoryLeaf34.setName("categoryLeaf34");
			categoryLeaf34.setParent(categoryComposite2);
			CategoryComponent categoryLeaf35 = new CategoryLeaf();
			categoryLeaf35.setName("categoryLeaf35");
			categoryLeaf35.setParent(categoryComposite2);
			CategoryComponent categoryLeaf36 = new CategoryLeaf();
			categoryLeaf36.setName("categoryLeaf36");
			categoryLeaf36.setParent(categoryComposite2);
			CategoryComponent categoryLeaf37 = new CategoryLeaf();
			categoryLeaf37.setName("categoryLeaf37");
			categoryLeaf37.setParent(categoryComposite2);
			CategoryComponent categoryLeaf4 = new CategoryLeaf();
			categoryLeaf4.setName("categoryLeaf4");
			categoryLeaf4.setParent(categoryComposite2);
			CategoryComponent categoryLeaf5 = new CategoryLeaf();
			categoryLeaf5.setName("categoryLeaf5");
			categoryLeaf5.setParent(categoryComposite2);

			categoryComponentRepository.save(categoryComposite1);
			categoryComponentRepository.save(categoryComposite2);
			categoryComponentRepository.save(categoryLeaf1);
			categoryComponentRepository.save(categoryLeaf2);
			categoryComponentRepository.save(categoryLeaf3);
			categoryComponentRepository.save(categoryLeaf31);
			categoryComponentRepository.save(categoryLeaf32);
			categoryComponentRepository.save(categoryLeaf33);
			categoryComponentRepository.save(categoryLeaf34);
			categoryComponentRepository.save(categoryLeaf35);
			categoryComponentRepository.save(categoryLeaf36);
			categoryComponentRepository.save(categoryLeaf37);
			categoryComponentRepository.save(categoryLeaf4);
			categoryComponentRepository.save(categoryLeaf5);

			CategoryComponent categoryComposite3 = new CategoryComposite();
			categoryComposite3.setName("categoryComposite3");
			categoryComposite3.setParent(categoryComposite2);

			CategoryComponent categoryLeaf8 = new CategoryLeaf();
			categoryLeaf8.setName("categoryLeaf8");
			categoryLeaf8.setParent(categoryComposite3);
			CategoryComponent categoryLeaf81 = new CategoryLeaf();
			categoryLeaf81.setName("categoryLeaf81");
			categoryLeaf81.setParent(categoryComposite3);
			CategoryComponent categoryLeaf82 = new CategoryLeaf();
			categoryLeaf82.setName("categoryLeaf82");
			categoryLeaf82.setParent(categoryComposite3);
			CategoryComponent categoryLeaf83 = new CategoryLeaf();
			categoryLeaf83.setName("categoryLeaf83");
			categoryLeaf83.setParent(categoryComposite3);
			CategoryComponent categoryLeaf84 = new CategoryLeaf();
			categoryLeaf84.setName("categoryLeaf83");
			categoryLeaf84.setParent(categoryComposite3);
			CategoryComponent categoryLeaf85 = new CategoryLeaf();
			categoryLeaf85.setName("categoryLeaf85");
			categoryLeaf85.setParent(categoryComposite3);

			categoryComponentRepository.save(categoryComposite3);
			categoryComponentRepository.save(categoryLeaf8);
			categoryComponentRepository.save(categoryLeaf81);
			categoryComponentRepository.save(categoryLeaf82);
			categoryComponentRepository.save(categoryLeaf83);
			categoryComponentRepository.save(categoryLeaf84);
			categoryComponentRepository.save(categoryLeaf85);

		};
	}

}
