package com.example.controller.rest;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ScoreSheet;
import com.example.service.SqlService;
//modify in workspace2
@RestController
@RequestMapping("/scoreSheet/movies")
public class MovieController {

	@Autowired
	private SqlService sqlService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ArrayList<ScoreSheet> getAll() throws SQLException {

		return sqlService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ScoreSheet getScoreSheetById(@PathVariable int id) {
		try {
			return sqlService.getScoreSheetById(id);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ArrayList<ScoreSheet> searchScoreSheetByCondition(@RequestParam String conditionType,
			@RequestParam String value) {
		try {
			
			return sqlService.getScoreSheetByCondition(conditionType, value);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(@RequestParam int id, @RequestParam String name, @RequestParam String info,
			@RequestParam double score) {

		try {

			sqlService.insert(id, name, info, score);
			return "success";

		} catch (SQLException e) {

			e.printStackTrace();
			return e.getMessage();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String update(@RequestParam int id, @RequestParam String name, @RequestParam String info,
			@RequestParam double score) {

		try {
			return sqlService.update(id, name, info, score);
		} catch (SQLException e) {

			e.printStackTrace();
			return e.getMessage();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public boolean delete(@RequestParam int id) {

		try {
			return sqlService.delete(id);
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
}
