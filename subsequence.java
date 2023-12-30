public class subsequence {
    public static void main(String[] args) {
     skip("", "baccdada");
    }
    public static void skip(String p, String S) {
        if (S.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = S.charAt(0);

        if (ch == 'a') {
          skip(p, S.substring(1));
        }
        else
        {
            skip(p + ch, S.substring(1));
        }
    }
}
