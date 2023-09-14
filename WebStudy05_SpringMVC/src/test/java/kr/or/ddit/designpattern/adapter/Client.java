package kr.or.ddit.designpattern.adapter;

public class Client {
	private Target target;
	
	public static void main(String[] args) {
		Client client = new Client();
		client.target = new Adapter( new Adaptee() );
		client.target.request();
	}
}
