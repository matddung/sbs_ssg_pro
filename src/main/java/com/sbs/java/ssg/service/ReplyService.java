package com.sbs.java.ssg.service;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dao.ReplyDao;
import com.sbs.java.ssg.dto.Reply;

public class ReplyService {
	private ReplyDao replyDao;

	public ReplyService() {
		replyDao = Container.replyDao;
	}

	public int ReplyWrite(int memberId, int articleId, String name, String body) {
		Reply reply = new Reply(memberId, articleId, name, body);
		return replyDao.ReplyWrite(reply);
	}
	
	public void delete(int id) {
		replyDao.delete(id);
	}
}