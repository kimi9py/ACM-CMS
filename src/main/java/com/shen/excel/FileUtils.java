package com.shen.excel;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;

import com.shen.express.pojo.AcmUser;

public class FileUtils {

	private static boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 读取元数据
	public static void readMeatData(String fileName) {

		try {
			Workbook workbook = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = workbook.getSheet(0);
			System.out.println(sheet.getName());
			int count = 0;
			String meta = "";
			for (int i = 0; i < sheet.getRows(); i++) {
				Cell[] cells = sheet.getRow(i);
				for (Cell cell : cells) {
					if (cell.getType() == CellType.LABEL) {

						meta = meta + count + ":" + ((LabelCell) cell).getString() + ";";
					}
					count++;
				}

				System.out.println();
			}

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static List<AcmUser> getDataFromExcel(String fileName) {
		ArrayList<AcmUser> users = new ArrayList<AcmUser>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = workbook.getSheet(0);// 第一张sheet
			for (int i = 1; i < sheet.getRows(); i++) {
				// 从index=1的那行 开始读起
				Cell[] cells = sheet.getRow(i);// 一共五个列
				AcmUser user = new AcmUser();
				user.setUser_id(cells[0].getContents());// 32 位 uuid
				user.setEmail(cells[1].getContents());
				user.setNick(cells[2].getContents());
				user.setSchool(cells[3].getContents());
				user.setIp("");
				user.setPassword(cells[0].getContents() + "wt");
				users.add(user);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
			users.clear(); // 失败全部 作废。
		}
		return users;
	}

}
