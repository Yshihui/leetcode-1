#include <gtest/gtest.h>

extern "C" {
#include <length-of-last-word.h>
}

TEST(leetcode_58, normal) {
    EXPECT_EQ(lengthOfLastWord_58("Hello World"), 5);
    EXPECT_EQ(lengthOfLastWord_58("Hello World!"), 6);
    EXPECT_EQ(lengthOfLastWord_58("Hello World  "), 5);
    EXPECT_EQ(lengthOfLastWord_58("Hello World . "), 1);
}