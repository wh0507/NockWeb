package sogo;

import java.util.ArrayList;

//テストドライバ
public class Driver {
	public static void main(String[] args) {

		//1.一覧表示呼び出し
		selectAll();
		//2.条件検査呼び出し
		jouken();
		//3.項目を追加する
		insert();
		//4.項目を更新する
		update();
		//5.項目を削除する
		delete();
	}

	//1.一覧表示
	public static void selectAll() {
		ShohinDAO dao = new ShohinDAO();
		ArrayList<ShohinBean> list = dao.selectAll();
		System.out.println("***出力結果（正常）***");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getId() + ",");
			System.out.print(list.get(i).getName() + ",");
			System.out.println(list.get(i).getKakaku());
		}
		if (list.size() == 0) {
			System.out.println("***出力結果（エラー）***");
			System.out.println("条件に合致したデータは存在しません");
		}
	}

	//2.条件検査
	public static void jouken() {
		String id = "00003"; //条件ID

		ShohinDAO dao = new ShohinDAO();

		ArrayList<ShohinBean> list = dao.jouken(id);

		if (id.equals("00003")) {
			System.out.println("***出力結果（正常）***");
			System.out.print(id + ",");
			System.out.print(list.get(0).getName() + ",");
			System.out.println(list.get(0).getKakaku());
		} else {
			System.out.println("***出力結果（エラー）***");
			System.out.println("条件に合致したデータは存在しません");
		}
	}

	//3.項目追加
	public static void insert() {
		//インスタンス生成
		ShohinDAO dao = new ShohinDAO();
		String id = "77777";
		String name = "ブルベリー";
		int kakaku = 700;

		int result = dao.insert(id, name, kakaku);

		if (result == 1) {
			System.out.println("***出力結果（正常）***");
			System.out.println("追加しました");
		} else {
			System.out.println("***出力結果（エラー）***");
			System.out.println("追加できませんでした");
		}
	}

	//4.項目更新
	public static void update() {
		//インスタンス生成
		ShohinDAO dao = new ShohinDAO();

		String id = "00003";
		String name = "ブルベリー";
		int kakaku = 700;

		int result = dao.update(id, name, kakaku);

		if (result == 1) {
			System.out.println("***出力結果（正常）***");
			System.out.println("更新しました");
		} else {
			System.out.println("***出力結果（エラー）***");
			System.out.println("更新できませんでした");
		}
	}

	//5.項目削除
	public static void delete() {
		ShohinDAO dao = new ShohinDAO();
		String id = "77777";

		int result = dao.delete(id);

		if (result == 1) {
			System.out.println("***出力結果（正常）***");
			System.out.println("削除しました");
		} else {
			System.out.println("***出力結果（エラー）***");
			System.out.println("削除できませんでした");
		}
	}
}
