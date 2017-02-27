/**
 * @author ming
 * @date 2017年2月10日 下午4:21:23
 */
package com.ksxt.vo;

import com.ksxt.model.Panduan;

public class PanduanVo {
    private String no;

    private String subject;

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
	
	public Panduan toPanduan() {
		Panduan panduan = new Panduan();
		panduan.setSubject(subject);
		panduan.setAnswer(answer);
		panduan.setAnalysis(analysis);
		
		return panduan;
	}
}