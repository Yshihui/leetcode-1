#include <gtest/gtest.h>

extern "C" {
#include <roman-to-integer.h>
}

TEST(leetcode_13, normal) {
    EXPECT_EQ(romanToInt_13("CCCLXXXVI"), 386);
    EXPECT_EQ(romanToInt_13("MCMXCVI"), 1996);
}