package com.spring.henallux.javawebproject.utility;

import com.spring.henallux.javawebproject.dataAccess.entity.*;
import com.spring.henallux.javawebproject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
	private Mapper mapper = new DozerBeanMapper();

	public UserEntity userModelToEntity(User user) {
		return mapper.map(user, UserEntity.class);
	}

	public User userEntityToUserModel(UserEntity user) {
		return mapper.map(user, User.class);
	}

	public ShipEntity shipModelToShipEntity(ShipEntity ship) {
		return mapper.map(ship, ShipEntity.class);
	}

	public Ship shipEntityToShipModel(ShipEntity ship) {
		return mapper.map(ship, Ship.class);
	}

	public ShipLanguage shipLanguageEntityToShipLanguageModel(ShipLanguageEntity shipLanguageEntity) {
		return mapper.map(shipLanguageEntity, ShipLanguage.class);
	}

	public ShipLanguageEntity shipLanguageModelToShipLanguageEntity(ShipLanguage shipLanguage) {
		return mapper.map(shipLanguage, ShipLanguageEntity.class);
	}

	public CategoryEntity categoryModelToCategoryEntity(Category category) {
		return mapper.map(category, CategoryEntity.class);
	}

	public Category categoryEntityToCategoryModel(CategoryEntity category) {
		return mapper.map(category, Category.class);
	}

	public CategoryLanguage categoryLanguageEntityToCategoryLanguageModel(CategoryLanguageEntity categoryLanguageEntity) {
		return mapper.map(categoryLanguageEntity, CategoryLanguage.class);
	}

	public CategoryLanguageEntity categoryLanguageModelToCategoryLanguageEntity(CategoryLanguage cheeseLanguage) {
		return mapper.map(cheeseLanguage, CategoryLanguageEntity.class);
	}

	public Order orderEntityToOrderModel(OrderEntity order) {
		return mapper.map(order, Order.class);
	}

	public OrderEntity orderModelToOrderEntity(Order order) {
		return mapper.map(order, OrderEntity.class);
	}

	public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
		return mapper.map(languageEntity, Language.class);
	}

	public LanguageEntity languageModelToLanguageEntity(Language language) {
		return mapper.map(language, LanguageEntity.class);
	}

	public Line lineEntityToLineModel(LineEntity lineEntity) {
		return mapper.map(lineEntity, Line.class);
	}

	public LineEntity lineModelToLineEntity(Line line) {
		return mapper.map(line, LineEntity.class);
	}
}
