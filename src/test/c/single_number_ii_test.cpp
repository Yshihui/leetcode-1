#include <gtest/gtest.h>

extern "C" {
#include <single_number_ii.h>
}

TEST(leetcode_137_1, normal) {
    int nums[] = {1, 2, 3, 1, 2, 3, 1, 2, 3, 4};
    EXPECT_EQ(singleNumber_137_1(nums, 10), 4);
}

TEST(leetcode_137_2, normal) {
    int nums[] = {1, 2, 3, 1, 2, 3, 1, 2, 3, 4};
    EXPECT_EQ(singleNumber_137_2(nums, 10), 4);
}
