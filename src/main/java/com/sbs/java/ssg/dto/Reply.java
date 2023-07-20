package com.sbs.java.ssg.dto;

import java.util.Map;

import lombok.Data;

@Data
public class Reply extends Dto {
	public int articleId;
	public int memberId;
	public String body;
	public String name;
	public int like;

	public Reply(int articleId, int memberId, String name, String body) {
		this(articleId, memberId, name, body, 0);
	}

	public Reply(int articleId, int memberId, String name, String body, int like) {
		this.articleId = articleId;
		this.memberId = memberId;
		this.name = name;
		this.body = body;
		this.like = like;
	}

	public Reply(Map<String, Object> row) {
		super(row);
		this.articleId = (int) row.get("articleId");
		this.memberId = (int) row.get("memberId");
		this.name = (String) row.get("name");
		this.body = (String) row.get("body");
		this.like = (int) row.get("like");
	}
}