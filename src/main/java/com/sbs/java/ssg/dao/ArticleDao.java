package com.sbs.java.ssg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.db.DBConnection;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.Board;

public class ArticleDao extends Dao {
	public List<Article> articles;
	private DBConnection dbConnection;

	public ArticleDao() {
		articles = new ArrayList<>();
		dbConnection = Container.getDBConnection();
	}

	public int write(Article article) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("INSERT INTO article "));
		sb.append(String.format("SET regDate = NOW(), "));
		sb.append(String.format("updateDate = NOW(), "));
		sb.append(String.format("title = '%s', ", article.title));
		sb.append(String.format("body = '%s', ", article.body));
		sb.append(String.format("nickname = '%s', ", article.nickname));
		sb.append(String.format("memberId = '%d', ", article.memberId));
		sb.append(String.format("boardId = '%d', ", article.boardId));
		sb.append(String.format("hit = '%d', ", article.hit));
		sb.append(String.format("`like` = '%d' ", article.like));
		
		return dbConnection.insert(sb.toString());
	}

	public List<Article> getArticles() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM article"));

		List<Article> articles = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			articles.add(new Article(row));
		}

		return articles;
	}
	
	public List<Article> getForPrintArticles(String boardCode, String searchkeyword) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT A.* "));
		sb.append(String.format("FROM `article` AS A "));
		sb.append(String.format("INNER JOIN `board` AS B "));
		sb.append(String.format("ON A.boardId = B.id "));
		sb.append(String.format("WHERE B.`code` = '%s' ", boardCode));
		if ( searchkeyword.length() > 0 ) {
			sb.append(String.format("AND A.title LIKE '%%%s%%' ", searchkeyword));
		}		
		sb.append(String.format("ORDER BY A.id DESC "));

		List<Article> articles = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			articles.add(new Article(row));
		}

		return articles;
	}
	
	public Article getArticle(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM article "));
		sb.append(String.format("WHERE id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Article(row);
	}

	public Article getForPrintArticle(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT A.*, M.nickname AS extra__writerName "));
		sb.append(String.format("FROM article AS A "));
		sb.append(String.format("INNER JOIN `member` as M "));
		sb.append(String.format("ON A.memberId = M.id "));
		sb.append(String.format("WHERE A.id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Article(row);
	}

	public int modify(int id, String title, String body) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE article "));
		sb.append(String.format("SET updateDate = NOW(), "));
		sb.append(String.format("title = '%s', ", title));
		sb.append(String.format("body = '%s' ", body));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}

	public int delete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM article "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public Board getBoard(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `board` "));
		sb.append(String.format("WHERE id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}

		return new Board(row);
	}

}