package com;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Save {

	// field
	static Object start;// 起始金額
	static Object save;// 期望存錢占比
	static Object spend;// 固定消費
	static Object life;// 生活開銷
	static Object fun;// 娛樂消費
	private static Integer firstStart;
	private static Integer hopeSave;
	private static Integer firstSpend;
	private static Integer spendLife;
	private static Integer haveFun;

	// contructors
	public Save(Integer firstStart, Integer hopeSave, Integer firstSpend, Integer spendLife, Integer haveFun) {
		super();
		Save.start = firstStart;
		Save.save = hopeSave;
		Save.spend = firstSpend;
		Save.life = spendLife;
		Save.fun = haveFun;

	}

	public Save() {
		super();
	}

	public static Object getStart() {
		return start;
	}

	public static void setStart(Object object) {
		Save.start = object;
	}

	public static Object getSave() {
		return save;
	}

	public static void setSave(Integer save) {
		Save.save = save;
	}

	public static Object getSpend() {
		return spend;
	}

	public static void setSpend(Integer spend) {
		Save.spend = spend;
	}

	public static Object getLife() {
		return life;
	}

	public static void setLife(Integer life) {
		Save.life = life;
	}

	public static Object getFun() {
		return fun;
	}

	public static void setFun(Integer fun) {
		Save.fun = fun;
	}

	// methods

	static void normalCount(JTextField start, JComboBox save) {
		firstStart = start.getText().trim().isEmpty() ? 0 : Integer.parseInt(start.getText());
		hopeSave = ((String) save.getSelectedItem()).trim().isEmpty() ? 0
				: Integer.parseInt((String) (save.getSelectedItem()));

		int startMoney = firstStart;
		int saveChoose = hopeSave;
		Integer saveMoney = 0;
		if (saveChoose == 30) {
			saveMoney = (int) (startMoney * 0.3);
			firstSpend = (int) (startMoney * 0.25);
			spendLife = (int) (startMoney * 0.25);
			haveFun = (int) (startMoney * 0.2);
		} else if (saveChoose == 50) {
			saveMoney = (int) (startMoney * 0.5);
			firstSpend = (int) (startMoney * 0.2);
			spendLife = (int) (startMoney * 0.2);
			haveFun = (int) (startMoney * 0.1);
		} else if (saveChoose == 70) {
			saveMoney = (int) (startMoney * 0.7);
			firstSpend = (int) (startMoney * 0.125);
			spendLife = (int) (startMoney * 0.125);
			haveFun = (int) (startMoney * 0.05);
		}
		Save.setStart(startMoney);
		Save.setSave(saveMoney);
		Save.setSpend(firstSpend);
		Save.setLife(spendLife);
		Save.setFun(haveFun);
	}

	static void creatCount(JTextField start, JTextField spend, JTextField life, JTextField fun) {
		firstStart = start.getText().trim().isEmpty() ? 0 : Integer.parseInt(start.getText());
		firstSpend = spend.getText().trim().isEmpty() ? 0 : Integer.parseInt(spend.getText());
		spendLife = life.getText().trim().isEmpty() ? 0 : Integer.parseInt(life.getText());
		haveFun = fun.getText().trim().isEmpty() ? 0 : Integer.parseInt(fun.getText());

		Save.hopeSave = firstStart - firstSpend - spendLife - haveFun;
		Save.setStart(firstStart);
		Save.setSpend(firstSpend);
		Save.setLife(spendLife);
		Save.setFun(haveFun);
	}

	static void overheadCount(JTextField start) {
		firstStart = start.getText().trim().isEmpty() ? 0 : Integer.parseInt(start.getText());

		hopeSave = (int) (firstStart * 0.9);
		firstSpend = (int) (firstStart * 0.05);
		spendLife = (int) (firstStart * 0.04);
		haveFun = (int) (firstStart * 0.01);

		Save.start = firstStart;
		Save.save = hopeSave;
		Save.spend = firstSpend;
		Save.life = spendLife;
		Save.fun = haveFun;

	}

	static String rules() {
		return "以每個月存錢目標為主的存錢計劃設計，僅供參考。\n接下來請嘗試規劃自己心目中的存錢計畫。";
	}

	static String showNormal() {

//		save30%、50%、70%，spend25%、20%、12.5%，life25%、20%、12.5%，fun20%、10%、5%
		return "自動幫您分配現有資金：" + Save.getStart() + "元\n存錢方式為：\n預計存錢金額：" + Save.getSave() + "元\n固定花費：" + Save.getSpend()
				+ "元\n生活開銷為：" + Save.getLife() + "元\n預計娛樂花費有" + Save.getFun() + "元";
	}

	static String showCreat() {

		return "您期望的存錢方式自動幫您分配的存錢方式為：\n每個月的金額先有：" + Save.getStart() + "元\n預計固定花費：" + Save.getSpend() + "元\n生活開銷："
				+ Save.getLife() + "元\n預計娛樂花費" + Save.getFun() + "元\n這樣算下來，這個月可以存入的金額為：" + Save.getSave() + "元";
	}

	static String showOverhead() {

		// save90%，spend5%、life4%、fun1%
		return "極限挑戰模式將會以存錢為目的，所以接下來" + Save.getStart() + "元\n分配為：\n存入金額：" + Save.getSave() + "元\n固定花費壓縮在："
				+ Save.getSpend() + "元\n生活開銷：" + Save.getLife() + "元\n娛樂開銷則會被壓制在：" + Save.getFun() + "元";
	}

	static String endPose() {
		return "預祝這個月可以收穫滿滿。";
	}

	static String wrong() {
		return "請輸入正確的數值，不要輸入非數字以外的任何東西，更不要輸入負值";
	}

}
