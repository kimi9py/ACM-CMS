package com.shen.express.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shen.excel.FileUtils;
import com.shen.express.dao.AcmUserDao;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.pojo.AcmUser;
import com.shen.express.service.AcmContestReservationService;
import com.shen.express.service.AcmUserService;

@Controller
@RequestMapping("file")
public class FileAction {

	@Autowired
	private AcmUserService acmUserService;

	@RequestMapping(value = "/upload.action")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, Map<String, Object> map, HttpServletRequest request, ModelMap model) {

		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<AcmUser> users = FileUtils.getDataFromExcel(targetFile.getAbsolutePath());
		// 保存用户。
		boolean bool = false;
		try {
			bool = acmUserService.insertUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("type", "1");
		if (bool) {
			return "redirect:../manager/uploadSuccess.action";
		}

		return "redirect:../manager/uploadFail.action";
	}

	@Autowired
	private AcmContestReservationService acmContestReservationService;

	@RequestMapping(value = "/uploadReservation.action")
	public String uploadReservation(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam String contest_id, Map<String, Object> map, HttpServletRequest request, ModelMap model) {
		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<AcmUser> users = FileUtils.getDataFromExcel(targetFile.getAbsolutePath());
		try {
			for (AcmUser user : users) {
				AcmContestReservation acr = new AcmContestReservation();
				acr.setContest_id(Integer.valueOf(contest_id));
				acr.setUser_id(user.getUser_id());
				acmContestReservationService.insertContestReservation(acr);
			}
			return "redirect:../manager/success.action";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:../manager/fail.action";
	}

}
