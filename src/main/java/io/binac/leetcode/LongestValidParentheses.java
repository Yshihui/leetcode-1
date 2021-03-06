package io.binac.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>Example 1:
 * <blockquote><pre>
 *     Input: "(()"
 *     Output: 2
 *     Explanation: The longest valid parentheses substring is "()"
 * </blockquote></pre>
 * Example 2:
 * <blockquote><pre>
 *     Input: ")()())"
 *     Output: 4
 *     Explanation: The longest valid parentheses substring is "()()"
 * </blockquote></pre>
 */
public class LongestValidParentheses {
    public static class Solution1 {
        public int longestValidParentheses(String s) {
            final int len = s.length();
            int result = 0;
            int top = -1;
            int start = -1;
            for (int i = 0; i < len; ++i) {
                switch (s.charAt(i)) {
                    case '(':
                        ++top;
                        break;
                    case ')':
                        if (top >= 0) {
                            --top;
                            if (top == -1)
                                result = Math.max(result, i - start);
                        } else
                            start = i;
                        break;
                }
            }

            top = -1;
            start = len;
            for (int i = len - 1; i >= 0; --i) {
                switch (s.charAt(i)) {
                    case ')':
                        ++top;
                        break;
                    case '(':
                        if (top >= 0) {
                            --top;
                            if (top == -1)
                                result = Math.max(result, start - i);
                        } else
                            start = i;
                        break;
                }
            }
            return result;
        }
    }

    public static class Solution2 {
        public int longestValidParentheses(String s) {
            final int len = s.length();
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int i = 0; i < len; ++i) {
                switch (s.charAt(i)) {
                    case '(':
                        stack.push(i);
                        break;
                    case ')':
                        stack.pop();
                        if (stack.empty())
                            stack.push(i);
                        else
                            result = Math.max(result, i - stack.peek());
                }
            }
            return result;
        }
    }

    public static class Solution3 {
        public int longestValidParentheses(String s) {
            final int len = s.length();
            if (len < 2)
                return 0;

            int dp[] = new int[len];
            dp[0] = 0;
            dp[1] = s.charAt(0) == '(' && s.charAt(1) == ')' ? 2 : 0;
            int result = dp[1];
            for (int i = 2; i < len; ++i) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = dp[i - 2] + 2;
                    } else if (dp[i - 1] > 0) {
                        final int j = i - dp[i - 1] - 1;
                        if (j >= 0 && s.charAt(j) == '(') {
                            dp[i] = dp[i - 1] + 2 + (j > 0 ? dp[j - 1] : 0);
                        }
                    }
                    result = Math.max(result, dp[i]);
                }
            }
            return result;
        }
    }
}
