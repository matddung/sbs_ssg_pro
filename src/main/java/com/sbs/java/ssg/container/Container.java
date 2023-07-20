package com.sbs.java.ssg.container;

import java.util.Scanner;

import com.sbs.java.ssg.controller.Session;
import com.sbs.java.ssg.dao.ArticleDao;
import com.sbs.java.ssg.dao.MemberDao;
import com.sbs.java.ssg.dao.ReplyDao;
import com.sbs.java.ssg.db.DBConnection;
import com.sbs.java.ssg.service.ArticleService;
import com.sbs.java.ssg.service.MemberService;
import com.sbs.java.ssg.service.ReplyService;

public class Container {
	public static Scanner sc;
	public static Session session;
	public static DBConnection dbConnection;
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;
	public static ReplyDao replyDao;
	public static ReplyService replyService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
		memberService = new MemberService();
		replyDao = new ReplyDao();
	}

	public static Scanner getScanner() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}

		return sc;
	}

	public static Session getSession() {
		if (session == null) {
			session = new Session();
		}

		return session;
	}

	public static DBConnection getDBConnection() {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}

		return dbConnection;
	}

}