package com.ksxt.vo;

import com.ksxt.model.Danxuan;
import com.ksxt.model.Duoxuan;

public class XuanzeVo {
    private String no;

    private String subject;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

	private String answer;

    private String analysis;

    public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	
	public Danxuan toDanxuan() {
		Danxuan danxuan = new Danxuan();
		danxuan.setAnalysis(analysis);
		danxuan.setAnswer(answer);
		danxuan.setOptionA(optionA);
		danxuan.setOptionB(optionB);
		danxuan.setOptionC(optionC);
		danxuan.setOptionD(optionD);
		danxuan.setSubject(subject);
		return danxuan;
	}
	
	public Duoxuan toDuoxuan() {
		Duoxuan duoxuan = new Duoxuan();
		duoxuan.setAnalysis(analysis);
		duoxuan.setAnswer(answer);
		duoxuan.setOptionA(optionA);
		duoxuan.setOptionB(optionB);
		duoxuan.setOptionC(optionC);
		duoxuan.setOptionD(optionD);
		duoxuan.setSubject(subject);
		return duoxuan;
	}
}