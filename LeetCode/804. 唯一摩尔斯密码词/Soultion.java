import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        // String类型的数组中有26个英文字母对应的密码
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set = new TreeSet();

        // 遍历一变words数组
        for (String word : words) {

            StringBuilder res = new StringBuilder();
            // 对word的进行遍历 经过循环在res中存储了word对应的摩斯码
            for (int i = 0; i < word.length(); i++) {
                // 获得当前字母进行偏移
                res.append(codes[word.charAt(i) - 'a']);
            }

            // 存进集合set中 在添加的过程中，如果两个单词摩斯码相同，集合自动忽略重复
            set.add(res.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int res = new Solution().uniqueMorseRepresentations(words);
        System.out.println(res);
    }

}