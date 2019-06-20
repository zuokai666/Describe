package org.zk.mysql.emoji.test;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author King
 * 
 */
public class EmojiTest3 {
	
	public static void main(String[] args) throws SQLException{
		String content = "1a左凯";
		byte[] bytes = content.getBytes(Charset.forName("UTF-8"));
		System.err.println(Arrays.toString(bytes));
		content = content.replaceAll("[\u3000-\u9fff]", "*");
		System.err.println(content);
	}
}