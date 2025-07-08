import java.io.*;

public class SelisihAnagramMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = in.readLine();
        char[] digits = N.toCharArray();

        String best = null;

        // Next permutation (yang lebih besar dari N)
        char[] next = digits.clone();
        if (nextPermutation(next)) {
            String candidate = new String(next);
            best = candidate;
        }

        // Prev permutation (yang lebih kecil dari N)
        char[] prev = digits.clone();
        if (prevPermutation(prev)) {
            String candidate = new String(prev);
            if (best == null || compareAbsDiff(N, candidate, best) < 0) {
                best = candidate;
            }
        }

        out.write(diffAbs(N, best));
        out.newLine();
        out.flush();
    }

    // Hitung nilai mutlak dari selisih string digit a dan b
    static String diffAbs(String a, String b) {
        if (a.equals(b)) return "0";

        boolean swapNeeded = false;
        if (a.length() < b.length() || (a.length() == b.length() && a.compareTo(b) < 0)) {
            String tmp = a;
            a = b;
            b = tmp;
            swapNeeded = true;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int al = a.length(), bl = b.length();
        for (int i = 0; i < al; i++) {
            int ai = a.charAt(al - 1 - i) - '0';
            int bi = (i < bl) ? b.charAt(bl - 1 - i) - '0' : 0;

            int sub = ai - bi - carry;
            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sub);
        }

        // Hapus nol di depan
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.setLength(sb.length() - 1);

        return sb.reverse().toString();
    }

    // Bandingkan dua selisih absolut terhadap N
    static int compareAbsDiff(String N, String a, String b) {
        String d1 = diffAbs(N, a);
        String d2 = diffAbs(N, b);
        if (d1.length() != d2.length()) return d1.length() - d2.length();
        return d1.compareTo(d2);
    }

    static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    static boolean prevPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] >= arr[i]) j--;

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    static void reverse(char[] arr, int l, int r) {
        while (l < r) swap(arr, l++, r--);
    }

    static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
