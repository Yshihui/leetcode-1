#include "add_binary.h"

#include <stdlib.h>
#include <string.h>

char *addBinary_67_1(char *a, char *b) {
    if (a == NULL || b == NULL) return NULL;

    int i = strlen(a), j = strlen(b);
    const int len = (i > j ? i : j) + 1;
    char *bits = (char *) calloc(len + 1, sizeof(char));
    int sum = 0, carry = 0;
    int k = len - 1;
    --i;
    --j;
    for (; i >= 0 && j >= 0; --i, --j, --k) {
        sum = a[i] - '0' + b[j] - '0' + carry;
        bits[k] = (char) (sum % 2 + '0');
        carry = sum / 2;
    }
    for (; i >= 0; --i, --k) {
        sum = a[i] - '0' + carry;
        bits[k] = (char) (sum % 2 + '0');
        carry = sum / 2;
    }
    for (; j >= 0; --j, --k) {
        sum = b[j] - '0' + carry;
        bits[k] = (char) (sum % 2 + '0');
        carry = sum / 2;
    }
    char *ret;
    if (carry == 1) {
        bits[0] = '1';
        ret = bits;
    } else {
        ++k;
        while (k < len - 1 && bits[k] == '0') ++k;
        ret = (char *) malloc((len - k + 1) * sizeof(char));
        strcpy(ret, bits + k);
        free(bits);
    }
    return ret;
}
