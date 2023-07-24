package com.sbs.java.ssg.dto;

import java.util.Map;

import lombok.Data;

@Data
public class Article extends Dto {
	public String title;
	public String body;
	public String name;
	public int memberId;
	public int boardId;
	public int hit;
	public int like;

	public Article(int memberId, int boardId, String name, String title, String body) {
		this(memberId, boardId, name, title, body, 0, 0);
	}

	public Article(int memberId, int boardId, String name, String title, String body, int hit, int like) {
		this.memberId = memberId;
		this.boardId = boardId;
		this.name = name;
		this.title = title;
		this.body = body;
		this.hit = hit;
		this.like = like;
	}

	public Article(Map<String, Object> row) {
		super(row);
		this.memberId = (int) row.get("memberId");
		this.boardId = (int) row.get("boardId");
		this.name = (String) row.get("name");
		this.title = (String) row.get("title");
		this.body = (String) row.get("body");
		this.hit = (int) row.get("hit");
		this.like = (int) row.get("like");
	}
}