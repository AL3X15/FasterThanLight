package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.LineDAO;
import com.spring.henallux.javawebproject.model.Line;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LineServices {
	private final LineDAO dao;

	@Autowired
	public LineServices(LineDAO dao, TestModel testLine) {
		this.dao = dao;
	}

	public Collection<Line> findLines(int orderId) {
		return dao.findLines(orderId);
	}

	public Line saveLine(Line line) {
		return dao.saveLine(line);
	}

	public Line delsteLine(Line line) {
		return dao.deleteLine(line);
	}
}
