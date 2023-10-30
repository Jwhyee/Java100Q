import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] alphas = new int[26];

        int c = System.in.read();

        while (c > 64) {
            if (c < 91) alphas[c - 65]++;
            else alphas[c - 97]++;
            c = System.in.read();
        }
        
        int max = -1, ch = -2;

        for (int i = 0; i < 26; i++) {
            if (alphas[i] > max) {
                max = alphas[i];
                ch = i;
            }
            else if (alphas[i] == max) ch = -2;
        }
        System.out.print((char) (ch+65));
    }
}