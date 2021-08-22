package leetCode;

public class StringTopic {
    public static void main(String[] args) {
        String s = "abbcccdddeeeeffff";
        //String ss = lengthOfLongestSubstring(s);
        reverseString("asdf".toCharArray());

    }

    public static void reverseString(char[] s) {
        for(int i=s.length-1,j = 0;i>j;i--,j++){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }

    private static String lengthOfLongestSubstring(String str) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //char d = str.charAt(++i);
            if (c == str.charAt(i+1)) {
                j++;
            } else {
                j = 0;
            }
            if (j > max) {
                max = j;
            }
        }
        return null;
    }
}
