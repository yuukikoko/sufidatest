package jp.sample1.com;

import java.util.ArrayList;

import jp.bean.com.ResBean;

public class ResList {


				//	概要
//	問い合わせ内容があるのかを判断するクラス
//-------------------------------------------------------------------------------------
	//	ResBeanクラス型の配列しかアクセスさせないようにしている
	//	ResBeanクラスだけインスタンスする
	private static ArrayList<ResBean> instance;

	//コンストラクタをカプセル化することで
	//	他からアクセスされたときに実行させないようにしている
	private ResList() {
	};

	//処理された内容（ResBrean)だけをインスタンスする
	public static synchronized ArrayList<ResBean> getInstance
			(String name, String title, String contents) {

		//		入力内容があるかの判断
		//	入力内容があるときは、インスタンス化を行う。
		if (instance == null) {
			instance = new ArrayList<ResBean>();
		}

		//ない場合は、作成を行いインスタンスを行う
		ResBean res = new ResBean();
		res.setName(name);
		res.setTitle(title);
		res.setContents(contents);
		instance.add(res);
		return instance;
	}

}
