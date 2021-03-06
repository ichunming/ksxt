/**
 * @author ming
 * @date 2017年2月10日 下午4:55:59
 */
package com.ksxt.vo;

import com.ksxt.model.Anlifenxi;
import com.ksxt.model.AnlifenxiSub;

public class AnlifenxiVo {
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

	public Anlifenxi toAnlifenxi() {
		Anlifenxi anlifenxi = new Anlifenxi();
		anlifenxi.setSubject(subject);
		
		return anlifenxi;
	}
	
	public AnlifenxiSub toAnlifenxiSub() {
		AnlifenxiSub anlifenxiSub = new AnlifenxiSub();
		anlifenxiSub.setSubject(subject);
		anlifenxiSub.setOptionA(optionA);
		anlifenxiSub.setOptionB(optionB);
		anlifenxiSub.setOptionC(optionC);
		anlifenxiSub.setOptionD(optionD);
		anlifenxiSub.setAnswer(answer);
		anlifenxiSub.setAnalysis(analysis);
		
		return anlifenxiSub;
	}
}
