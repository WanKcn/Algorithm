import java.util.ArrayList;

public class Solution {
    /**
     * 解密密文
     *
     * @param str string字符串 密文
     * @param d   int整型 偏移量
     * @return string字符串
     */
    public String decode(String str, int d) {
        StringBuilder res = new StringBuilder();
        ArrayList al = new ArrayList();
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        for (char n : arr)
            al.add(n);

        for (int i = 0; i < str.length(); i++) {
            int index = al.indexOf(str.charAt(i));
            if (index - d < 0) {
                index += 62;
            }
            res.append(al.get(index - d));
        }
        return res.toString();
    }
    
}
