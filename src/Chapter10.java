import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 以下記述
		// 題目の確認：ラムダ式とメソッド参照を伴うストリーム処理の実装

		// stream 開始
		 long notYetCount = list.stream()
		 .filter(yet -> yet.isDone() == false)
		 .count(); // notYetCount に list 中の false 個数を返してフィニッシュ

		 System.out.println("未完了のタスクの個数は" + notYetCount + "\n【未完了のタスクを昇順に並び替えて一覧表示】");

		// stream 開始
		 list.stream()
		 .filter(yet -> yet.isDone() == false)
		 .sorted((yet1, yet2) -> yet1.compareTo(yet2)) // falseだったものを並び替え
		 .forEach(System.out::println); // 順に出力してフィニッシュ
		 
// 【別解】未完了のタスクでリストを作り、さらにストリーム処理を行う。元のリストが伸びると重くなりそう。
//         リストを分ける利点としては、編集時のフィールドにすることで元リストへの影響を軽減するくらい…かなぁ。
//
//		List<Task> notYet = new ArrayList<>();
//
//		notYet = list.stream()
//				.filter(yet -> yet.isDone() == false)
//				.sorted((yet1, yet2) -> yet1.compareTo(yet2))
//				.collect(Collectors.toList());
//
//		System.out.println("未完了のタスクの個数は" + notYet.size() + "\n【未完了のタスクを昇順に並び替えて一覧表示】");
//
//		notYet.stream().forEach(System.out::println);

	}
}