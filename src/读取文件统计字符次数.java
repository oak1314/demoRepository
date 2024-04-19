package anli;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
读取文件统计字符次数
需求：统计文件中每一个字符出现的次数，随后展示在控制台

效果：
A(1)B(2)C(3)
*/
public class 读取文件统计字符次数 {
    public static void main(String[] args) {
        String filePath = "D:\\example.txt"; // 文件的路径，根据实际情况修改
        FileReader reader = null;
        try {
            reader = new FileReader(filePath); // 创建FileReader对象，用于读取文件
            Map<Character, Integer> characterCounts = new HashMap<>(); // 创建HashMap存储字符及其出现次数
            int c;

            while ((c = reader.read()) != -1) { // 一直读取到文件结束
                char character = (char) c; // 将读取的整数值转换为字符
                characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1); // 计数
            }

            // 打印每个字符及其出现的次数
            for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
                System.out.println("字符 '" + entry.getKey() + "' 出现次数: " + entry.getValue());
            }
        } catch (IOException ex) {
            System.out.println("读取文件时出错: " + ex.getMessage());
        } finally {
            try {
                if (reader != null) reader.close(); // 关闭流
            } catch (IOException ex) {
                System.out.println("关闭文件时出错: " + ex.getMessage());
            }
        }
    }
}
