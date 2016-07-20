package com.shen.express.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.pojo.AcmUser;
import com.shen.express.pojo.ExpressSite;
import com.shen.express.service.AcmContestProblemService;
import com.shen.express.service.AcmContestReservationService;
import com.shen.express.service.AcmContestService;
import com.shen.express.service.AcmUserService;
import com.shen.express.service.CommonService;

@Controller
@RequestMapping("manager")
public class ManagerAction {

	@Autowired
	private CommonService commonService;

	@Autowired
	private AcmContestProblemService acmContestProblemService;

	@Autowired
	private AcmContestReservationService acmContestReservationService;

	public boolean checkUser(HttpServletRequest request) {
		// HttpSession session = ServletActionContext.getRequest().getSession();
		HttpSession session = request.getSession();
		String adminLogined = (String) session.getAttribute("adminLogined");
		if (adminLogined == null || !adminLogined.trim().equals("true")) {

			return false;
		} else {
			ExpressSite ec = (ExpressSite) session.getAttribute("currentUser");
			// setUser(userDAO.findUserByName(currentUser));
			if (ec == null) {
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean checkRoot(HttpServletRequest request) {
		// HttpSession session = ServletActionContext.getRequest().getSession();
		HttpSession session = request.getSession();
		String adminLogined = (String) session.getAttribute("adminLogined");
		if (adminLogined == null || !adminLogined.trim().equals("true")) {

			return false;
		} else {
			// ExpressSite ec = (ExpressSite)
			// session.getAttribute("currentUser");
			String root = (String) session.getAttribute("who");
			// setUser(userDAO.findUserByName(currentUser));
			if (root == null) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 首页。欢迎
	 * 
	 * @return
	 */
	@RequestMapping(value = { "welcome.action" })
	public String welcome(HttpServletRequest request, Map<String, Object> map) {
		if (!checkRoot(request)) {
			return "error";
		}
		String who = (String) request.getSession().getAttribute("who");
		map.put("user", who);
		return "manager/welcome";
	}

	/**
	 * 用户信息导入
	 * 
	 * @return
	 */
	@RequestMapping(value = { "userImportShow.action" })
	public String userImportShow(HttpServletRequest request, Map<String, Object> map) {
		if (!checkRoot(request)) {
			return "error";
		}
		List<AcmUser> list = acmUserService.getUsers();
		map.put("users", list);
		return "manager/userImportShow";
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = { "contestImportShow.action" })
	public String contestImportShow(HttpServletRequest request, Map<String, Object> map) {
		if (!checkRoot(request)) {
			return "error";
		}
		List<AcmContest> list = acmContestService.getContests();
		map.put("contests", list);

		return "manager/contestImportShow";
	}

	@Autowired
	private AcmUserService acmUserService;

	@Autowired
	private AcmContestService acmContestService;

	/**
	 * 
	 * 需要将比赛的id加入map，这样界面 可以选择比赛的 id
	 * 
	 * @return
	 */
	@RequestMapping(value = { "problemImportShow.action" })
	public String problemImportShow(HttpServletRequest request, Map<String, Object> map) {
		if (!checkRoot(request)) {
			return "error";
		}

		// 选择 后面的五个 id
		List<AcmContest> contests = acmContestService.getContests();
		List<String> contest_ids = new ArrayList<String>();
		for (AcmContest contest : contests) {
			contest_ids.add(String.valueOf(contest.getContest_id()));
		}
		map.put("contest_ids", contest_ids);

		List<AcmContestProblem> problems = acmContestProblemService.showProblems();
		map.put("problems", problems);

		return "manager/problemImportShow";
	}

	/**
	 * 
	 * 需要将比赛的id加入map 跟user 加入，这样界面 可以选择比赛的 id
	 * 
	 * @return
	 */
	@RequestMapping(value = { "reservationImportShow.action" })
	public String reservationImportShow(HttpServletRequest request, Map<String, Object> map) {
		if (!checkRoot(request)) {
			return "error";
		}
		List<AcmContest> contests = acmContestService.getContests();
		List<String> contest_ids = new ArrayList<String>();
		for (AcmContest contest : contests) {
			contest_ids.add(String.valueOf(contest.getContest_id()));
		}

		List<AcmUser> users = acmUserService.getUsers();
		List<String> user_ids = new ArrayList<String>();
		for (AcmUser user : users) {
			user_ids.add(String.valueOf(user.getNick()));
		}

		map.put("user_ids", user_ids);
		map.put("contest_ids", contest_ids);

		List<AcmContestReservation> list = acmContestReservationService.getReservations();
		map.put("reservations", list);
		return "manager/reservationImportShow";
	}

	/**
	 * 
	 * 上传成功
	 * 
	 * @return
	 */
	@RequestMapping(value = { "uploadSuccess.action" })
	public String uploadSuccess(HttpServletRequest request, Map<String, Object> map, @RequestParam String type) {
		if (!checkRoot(request)) {
			return "error";
		}
		map.put("type", type);
		return "manager/uploadSuccess";
	}

	/**
	 * 
	 * 上传失败
	 * 
	 * @return
	 */
	@RequestMapping(value = { "uploadFail.action" })
	public String uploadFail(HttpServletRequest request, Map<String, Object> map, @RequestParam String type) {
		if (!checkRoot(request)) {
			return "error";
		}
		map.put("type", type);
		return "manager/uploadFail";
	}

	@RequestMapping(value = "/success.action")
	public String success(HttpServletRequest request) {
		return "info/success";
	}

	@RequestMapping(value = "/fail.action")
	public String fail(HttpServletRequest request) {
		return "info/fail";
	}

	@RequestMapping(value = "/userModify.action")
	public String userModify(HttpServletRequest request, String user_id, Map<String, Object> map) {
		AcmUser au = acmUserService.getUser(user_id);
		map.put("user", au);
		return "manager/userModify";
	}

	@RequestMapping(value = "/contestModify.action")
	public String contestModify(HttpServletRequest request, String id, Map<String, Object> map) {
		map.put("xx", acmContestService.getContest(id));
		return "manager/contestModify";
	}

	@RequestMapping(value = "/proModify.action")
	public String proModify(HttpServletRequest request, String id, Map<String, Object> map) {

		map.put("xx", acmContestProblemService.getPro(id));
		return "manager/problemModify";
	}

	@RequestMapping(value = "/reModify.action")
	public String reModify(HttpServletRequest request, String id, Map<String, Object> map) {

		map.put("xx", acmContestReservationService.getRe(id));
		List<AcmUser> users = acmUserService.getUsers();
		List<String> user_ids = new ArrayList<String>();
		for (AcmUser user : users) {
			user_ids.add(String.valueOf(user.getUser_id()));
		}
		map.put("user_ids", user_ids);
		return "manager/reservationModify";
	}

	@RequestMapping(value = "/userModifyC.action")
	public String userModifyC(HttpServletRequest request, String userid, String name, String school, String email, Map<String, Object> map) {

		try {

			AcmUser au = new AcmUser();
			au.setUser_id(userid);
			au.setNick(name);
			au.setSchool(school);
			au.setEmail(email);
			au.setPassword(acmUserService.getUser(userid).getPassword());
			au.setIp("");
			if (acmUserService.ModifyUser(au)) {

				return "info/success";
			} else {

				return "info/fail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "info/fail";

		}
	}

	@RequestMapping(value = "/contestModifyC.action")
	public String contestModifyC(HttpServletRequest request, String id, String paper_path, String title, Map<String, Object> map) {
		try {

			AcmContest ac = acmContestService.getContest(id);
			ac.setPaper_path(paper_path);
			ac.setTitle(title);

			if (acmContestService.modifyContest(ac)) {

				return "info/success";
			} else {

				return "info/fail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "info/fail";

		}
	}

	@RequestMapping(value = "/proModifyC.action")
	public String proModifyC(HttpServletRequest request, String id, String contest_id, String problem1, String title1, Map<String, Object> map) {

		try {
			AcmContestProblem acp = acmContestProblemService.getPro(id);

			acp.setContest_id(Integer.valueOf(contest_id));
			acp.setProblem_id(Integer.valueOf(problem1));
			acp.setTitle(title1);

			if (acmContestProblemService.modifyPro(acp)) {

				return "info/success";
			} else {

				return "info/fail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "info/fail";

		}
	}

	@RequestMapping(value = "/reModifyC.action")
	public String reModifyC(HttpServletRequest request, String id, String contest_id, String user, Map<String, Object> map) {

		try {

			AcmContestReservation acr = acmContestReservationService.getRe(id);
			acr.setContest_id(Integer.valueOf(contest_id));
			acr.setUser_id(user);

			if (acmContestReservationService.modifyRe(acr)) {

				return "info/success";
			} else {

				return "info/fail";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "info/fail";

		}
	}
}
