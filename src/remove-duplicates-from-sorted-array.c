#include <stddef.h>
#include <remove-duplicates-from-sorted-array.h>

int removeDuplicates_26(int *nums, int numsSize) {
    if (nums == NULL || numsSize < 0) return -1;
    if (numsSize < 2) return numsSize;

    int index = 0;
    for (int i = 1; i < numsSize; ++i) {
        if (nums[i] != nums[index]) {
            nums[++index] = nums[i];
        }
    }
    return index + 1;
}
