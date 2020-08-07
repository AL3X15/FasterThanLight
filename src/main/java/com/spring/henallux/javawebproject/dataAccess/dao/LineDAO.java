package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.LineEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.LineRepository;
import com.spring.henallux.javawebproject.model.Line;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class LineDAO {
	private final LineRepository dataAccess;
	private final ProviderConverter mapper;

	@Autowired
	public LineDAO(LineRepository dataAccess, ProviderConverter mapper) {
		this.dataAccess = dataAccess;
		this.mapper = mapper;
	}

	public Collection<Line> findLines(int orderId) {
		return dataAccess.findByOrderId(orderId).stream().map(mapper::lineEntityToLineModel).collect(Collectors.toList());
	}

	public Line saveLine(Line line) {
		LineEntity lineEntity = mapper.lineModelToLineEntity(line);
		dataAccess.save(lineEntity);
		return line;
	}

	public Line deleteLine(Line line) {
		dataAccess.delete(mapper.lineModelToLineEntity(line));
		return line;
	}
}
