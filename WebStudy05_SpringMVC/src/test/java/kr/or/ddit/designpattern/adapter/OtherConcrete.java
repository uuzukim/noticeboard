package kr.or.ddit.designpattern.adapter;

public class OtherConcrete implements Target {

	@Override
	public void request() {
		System.out.println("OtherConcrete 에서 요청 처리함.");
	}

}
