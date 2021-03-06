package io.binac.leetcode;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * <p>Below is one possible representation of s1 = "great":
 * <blockquote><pre>
 *         great
 *        /    \
 *       gr    eat
 *      / \    /  \
 *     g   r  e   at
 *                / \
 *               a   t
 * </blockquote></pre>
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * <p>For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <blockquote><pre>
 *         rgeat
 *        /    \
 *       rg    eat
 *      / \    /  \
 *     r   g  e   at
 *                / \
 *               a   t
 * </blockquote></pre>
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * <p>Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <blockquote><pre>
 *         rgtae
 *        /    \
 *       rg    tae
 *      / \    /  \
 *     r   g  ta  e
 *            / \
 *           t   a
 * </blockquote></pre>
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * <p>Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * <p>Example 1:
 * <blockquote><pre>
 *     Input: s1 = "great", s2 = "rgeat"
 *     Output: true
 * </blockquote></pre>
 * Example 2:
 * <blockquote><pre>
 *     Input: s1 = "abcde", s2 = "caebd"
 *     Output: false
 * </blockquote></pre>
 */
public class ScrambleString {
    public static class Solution1 {
        public boolean isScramble(String s1, String s2) {
            final int len = s1.length();
            if (len == 0 || len != s2.length())
                throw new IllegalArgumentException();

            boolean dp[][][] = new boolean[len + 1][len][len];
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    if (s1.charAt(i) == s2.charAt(j))
                        dp[1][i][j] = true;
                }
            }
            for (int l = 2; l <= len; ++l) {
                for (int i = 0; i + l <= len; ++i) {
                    for (int j = 0; j + l <= len; ++j) {
                        for (int k = 1; k < l; ++k) {
                            if ((dp[k][i][j] && dp[l - k][i + k][j + k])
                                    || (dp[k][i][j + l - k] && dp[l - k][i + k][j])) {
                                dp[l][i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
            return dp[len][0][0];
        }
    }

    public static class Solution2 {
        private boolean isScramble(char[] str1, int offset1, char[] str2, int offset2, int len) {
            if (len == 1)
                return str1[offset1] == str2[offset2];
            int count[] = new int[26];
            for (int i = 0; i < len; ++i) {
                ++count[str1[offset1 + i] - 'a'];
                --count[str2[offset2 + i] - 'a'];
            }
            for (int i = 0; i < 26; ++i)
                if (count[i] != 0)
                    return false;
            for (int l = 1; l < len; ++l) {
                if ((isScramble(str1, offset1, str2, offset2, l) && isScramble(str1, offset1 + l, str2, offset2 + l, len - l))
                        || (isScramble(str1, offset1, str2, offset2 + len - l, l) && isScramble(str1, offset1 + l, str2, offset2, len - l)))
                    return true;
            }
            return false;
        }

        public boolean isScramble(String s1, String s2) {
            char str1[] = s1.toCharArray(), str2[] = s2.toCharArray();
            if (str1.length == 0 || str1.length != str2.length)
                throw new IllegalArgumentException();
            return isScramble(str1, 0, str2, 0, str1.length);
        }
    }
}
