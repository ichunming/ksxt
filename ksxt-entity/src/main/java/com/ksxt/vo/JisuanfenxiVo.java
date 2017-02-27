/**
 * @author ming
 * @date 2017年2月10日 下午4:58:10
 */
package com.ksxt.vo;

import com.ksxt.model.Jisuanfenxi;
import com.ksxt.model.JisuanfenxiSub;

public class JisuanfenxiVo {
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
	
	public Jisuanfenxi toJisuanfenxi() {
		Jisuanfenxi jisuanfenxi = new Jisuanfenxi();
		jisuanfenxi.setSubject(subject);
		
		return jisuanfenxi;
	}
	
	public JisuanfenxiSub toJisuanfenxiSub() {
		JisuanfenxiSub jisuanfenxiSub = new JisuanfenxiSub();
		jisuanfenxiSub.setAnswer(answer);
		jisuanfenxiSub.setAnalysis(analysis);
		
		return jisuanfenxiSub;
	}
}
