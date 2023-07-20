package com.sbs.java.ssg.service;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dao.ReplyDao;
import com.sbs.java.ssg.dto.Reply;

public class ReplyService {
	private ReplyDao replyDao;

	public ReplyService() {
		replyDao = Container.replyDao;
	}

	public int ReplyWrite(int memberId, int boardId, String name, String body) {
		Reply reply = new Reply(memberId, boardId, name, body);
		return replyDao.ReplyWrite(reply);
	}
}