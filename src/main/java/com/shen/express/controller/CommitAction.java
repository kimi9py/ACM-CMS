package com.shen.express.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.pojo.AcmUser;
import com.shen.express.service.AcmContestProblemService;
import com.shen.express.service.AcmContestReservationService;
import com.shen.express.service.AcmContestService;
import com.shen.express.service.AcmUserService;

/**
 * 处理各种提交事务
 * 
 * @author user
 * 
 */
@Controller
@RequestMapping("commit")
public class CommitAction {

	@Autowired
	private AcmUserService acmUserService;

	@Autowired
	private AcmContestService acmContestService;

	@Autowired
	private AcmContestProblemService acmContestProblemService;

	@Autowired
	private AcmContestReservationService acmContestReservationService;

	@RequestMapping(value = "/userImportCommit.action")
	public String userImportCommit(HttpServletRequest request, Map<String, Object> map, @RequestParam String userid, @RequestParam String name, @RequestParam String nick, @RequestParam String school, @RequestParam String email) {
		// 单个用户插入
		AcmUser user = new AcmUser();
		// user id 是学号
		user.setUser_id(userid);// 32 位 uuid
		user.setEmail(email);
		user.setNick(nick);
		user.setPassword(userid + "wt");
		user.setSchool(school);
		user.setLanguage(0);
		user.setIp("");

		boolean bool = acmUserService.insertUser(user);
		map.put("type", "0");
		if (bool) {
			return "redirect:../manager/uploadSuccess.action";
		}

		return "redirect:../manager/uploadFail.action";
	}

	@RequestMapping(value = "/contestImportCommit.action")
	public String contestImportCommit(HttpServletRequest request, @RequestParam String title, @RequestParam String start_time, @RequestParam String end_time, @RequestParam String description, @RequestParam String paper_path) {
		AcmContest ac = new AcmContest();
		ac.setTitle(title);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMDD");

		try {
			ac.setContest_id(Integer.valueOf(sdf2.format(sdf.parse(start_time))));
			ac.setStart_time(sdf.parse(start_time));
			ac.setEnd_time(sdf.parse(end_time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ac.setPaper_path(paper_path);
		boolean bool = acmContestService.insertContest(ac);
		if (bool) {
			return "redirect:../manager/success.action";
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/problemImportCommit.action")
	public String problemImportCommit(HttpServletRequest request, @RequestParam String select01, @RequestParam String problem1, @RequestParam String problem2, @RequestParam String title1, @RequestParam String title2) {
		try {
			Integer contest_id = Integer.parseInt(select01);
			Integer p1 = Integer.parseInt(problem1);
			Integer p2 = Integer.parseInt(problem2);

			AcmContestProblem ap = new AcmContestProblem();
			ap.setContest_id(contest_id);
			ap.setTitle(title1);
			ap.setProblem_id(p1);

			acmContestProblemService.insertContestProblem(ap);
			AcmContestProblem ap2 = new AcmContestProblem();
			ap2.setContest_id(contest_id);
			ap2.setTitle(title2);
			ap2.setProblem_id(p2);
			boolean bool = acmContestProblemService.insertContestProblem(ap);

			if (bool) {
				return "redirect:../manager/success.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/reservationImportCommit.action")
	public String reservationImportCommit(HttpServletRequest request, @RequestParam String contest_id, @RequestParam(value = "users") String[] users) {

		try {
			for (String user_id : users) {
				AcmContestReservation acr = new AcmContestReservation();
				acr.setContest_id(Integer.valueOf(contest_id));
				acr.setUser_id(user_id);
				acmContestReservationService.insertContestReservation(acr);
			}
			return "redirect:../manager/success.action";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/userd.action")
	public String userd(HttpServletRequest request, @RequestParam String id) {
		try {
			AcmUser user = new AcmUser();
			user.setUser_id(id);
			boolean bool = acmUserService.delete(user);
			if (bool) {
				return "redirect:../manager/success.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/cond.action")
	public String cond(HttpServletRequest request, @RequestParam String id) {
		try {
			AcmContest ac = new AcmContest();
			ac.setContest_id(Integer.valueOf(id));
			boolean bool = acmContestService.delete(ac);
			if (bool) {
				return "redirect:../manager/success.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/prod.action")
	public String prod(HttpServletRequest request, @RequestParam String id) {
		try {
			AcmContestProblem acp = new AcmContestProblem();
			acp.setId(Integer.valueOf(id));
			boolean bool = acmContestProblemService.delete(acp);
			if (bool) {
				return "redirect:../manager/success.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

	@RequestMapping(value = "/reserd.action")
	public String reserd(HttpServletRequest request, @RequestParam String id) {
		try {
			AcmContestReservation acp = new AcmContestReservation();
			acp.setId(Integer.valueOf(id));
			boolean bool = acmContestReservationService.delete(acp);
			if (bool) {
				return "redirect:../manager/success.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

}
