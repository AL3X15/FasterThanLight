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

	public CheeseEntity cheeseModelToCheeseEntity(Cheese cheese) {
		return mapper.map(cheese, CheeseEntity.class);
	}

	public Cheese cheeseEntityToCheeseModel(CheeseEntity cheese) {
		return mapper.map(cheese, Cheese.class);
	}

	public CheeseLanguage cheeseLanguageEntityToCheeseLanguageModel(CheeseLanguageEntity cheeseLanguageEntity) {
		return mapper.map(cheeseLanguageEntity, CheeseLanguage.class);
	}

	public CheeseLanguageEntity cheeseLanguageModelToCheeseLanguageEntity(CheeseLanguage cheeseLanguage) {
		return mapper.map(cheeseLanguage, CheeseLanguageEntity.class);
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
