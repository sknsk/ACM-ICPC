import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class source_ally {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());

		int input[] = new int[n + 1];
		List<Integer>[] listArray = new ArrayList[n + 1];

		for (int i = 0; i < q; i++) {
			String[] splits = br.readLine().split(" ");
			int type = Integer.parseInt(splits[0]);
			int a = Integer.parseInt(splits[1]);
			int b = Integer.parseInt(splits[2]);

			if (type == 0) {
				if (input[a] == 0 && input[b] == 0) {
					int group = a < b ? a : b;
					listArray[group] = new ArrayList<Integer>();
					listArray[group].add(a);
					listArray[group].add(b);
					input[a] = group;
					input[b] = group;
				} else if (input[a] == 0 && input[b] != 0) {
					listArray[input[b]].add(a);
					input[a] = input[b];
				} else if (input[a] != 0 && input[b] == 0) {
					listArray[input[a]].add(b);
					input[b] = input[a];
				} else if (input[a] == input[b]) {

				} else {
					int group = input[a] < input[b] ? input[a] : input[b];
					int src = input[a] > input[b] ? input[a] : input[b];
					for (int z = 0; z < listArray[src].size(); z++) {
						input[listArray[src].get(z)] = group;
						listArray[group].add(listArray[src].get(z));
					}
					listArray[src] = null;
				}
			} else {
				if (input[a] != input[b]) {
					bw.write(0 + "\n");
				} else if (input[a] == input[b] && (input[a] != 0 && input[b] != 0)) {
					bw.write(1 + "\n");
				} else if (input[a] == 0 && input[b] == 0) {
					if (a == b) {
						bw.write(1 + "\n");
					} else {
						bw.write(0 + "\n");
					}
				}
			}
		}
		bw.flush(); // 이 부분이 없으면 출력이 되지 않을 수도 있음
		bw.close();
		br.close();
	}
}