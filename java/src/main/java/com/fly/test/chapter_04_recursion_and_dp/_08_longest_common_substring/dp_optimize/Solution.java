package com.fly.test.chapter_04_recursion_and_dp._08_longest_common_substring.dp_optimize;

public class Solution {

	public static String lcst2(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int row = 0; 				// 斜线开始位置的行
		int col = chs2.length - 1;	// 斜线开始位置的列
		
		int max = 0; // 记录最大长度
		int end = 0; // 最大长度更新时，记录子串的结尾位置
		
		// 每根斜线从第一行开始计算
		while (row < chs1.length) {
			int i = row;
			int j = col;
			
			int len = 0;
			// 从(i,j)开始向右下方遍历
			while (i < chs1.length && j < chs2.length) {
				if (chs1[i] != chs2[j]) {
					len = 0;
				} else {
					len++;
				}
				// 记录最大值，以及结束字符的位置
				if (len > max) {
					end = i;
					max = len;
				}
				i++;
				j++;
			}
			if (col > 0) { // 斜线开始位置的列先向左移动
				col--;
			} else { // 列移动到最左之后，行向下移动
				row++;
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

	public static void main(String[] args) {
//		System.out.println(lcst2("yrtqyfxyrmbasfmkbuudetaahxxgvcpkfhlkfxtjvguizsmwbnwamftshffyzumqfzqvirxgjjuocobvhvgstvrynduavkvntvxgnravjyfjkycguqyrnbnwnoqvhh", 
//				"xxzjrwyqtgzfgxyitvszmltcsdjweeycqgzsazahpqrvlgvwexcfwkusmuyltvtbjftkvwebmjctwbfcxfimoevbquznojlzkxygruhebhostshenguhymzjxhkjstiwzgyudtfeddgqlegxesngnlbubkhzfmspalfajiqsvohghxhswjiimnyazfmgqazdewfptldiilrwkhuntvseohykutjecuhg"));
//	
		System.out.println(lcst2("ujlzfqqscymxyooumhfwuokwvjnkboqwbsjktburxsazwrjltmmnuxsigpvsusgpztxodwfhagyzxpocvmladimtzfwwgkbarhmjthuubccwzvkgadrnpcr", 
				"qmuwdtbmltlciaxogzjjktzyegefnkezoouvhbxxtnnctihybsnchumrxysynyhciezgbwjzljuhpgiiuwouyevymbhwsopcyhyhswhmdpdqajvpgitqxczkfegrqhgxlvykbhymnjjpgufdxccjacnfzxmejzrkywwazfiyuwmfbifhllebzojlqlqgpamzwawpgjaatgnrfpmlmgvsnlhufmvzrjwhmdwhxxiksqbwqgkakivvahjntcswdyllwjtwdyspae"));
	}

}
