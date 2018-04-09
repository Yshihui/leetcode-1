#include <gtest/gtest.h>

extern "C" {
#include <insertion-sort-list.h>
}

TEST(leetcode_147, normal) {
    int nums[] = {7, 5, 1, 3, 5, 9, 1, 2};
    struct ListNode *list = list_from_array(nums, 8);
    list_print(list);
    list = insertionSortList_147(list);
    list_print(list);
    list_free(list);
}