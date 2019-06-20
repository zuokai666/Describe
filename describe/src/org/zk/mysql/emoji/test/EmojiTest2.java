package org.zk.mysql.emoji.test;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 
 * \xF0\x9F\x99\x8F
 * \xF0\x9F\x98\x80
 * \xF0\x9F\x92\x8C
 * 
 * @author King
 * 
 */
public class EmojiTest2 {
	
	public static void main(String[] args) throws SQLException{
		String content = "🍻";//\xF0\x9F\x8D\xBB
		for(int i=0;i<content.length();i++){
			char vv = content.charAt(i);
			System.err.println(vv);
		}
		System.err.println(content.length());
		byte[] bytes = content.getBytes(Charset.forName("unicode"));
		System.err.println(Arrays.toString(bytes));
		System.out.println(bytes.length);
		content = content.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");		
//		content = content.replaceAll("[\\ud800-\\udfff]", "*");
		System.out.println(content);
	}
}



/**
\ud83c\udf7b

\ud83c\udf7b\ud83c\udf7c\ud83c\udf7d\ufe0f\ud83c\udf80\ud83c\udf81\ud83c\udf82\ud83c\udf83


*/

