#include <iostream>

using namespace std;

int main() {
    int n = 0; // n的范围[1000,9999]
    int front, behind;
    // 从平方根开始考虑
    for (int i = 31;; i++) {
        n = i * i;
        if (n > 9999)
            break;        // 退出循环 n不可能超过9999
        front = n / 100;
        behind = n % 100;
        if ((front / 10 == behind % 10) && (behind / 10 == behind % 10))   // 判断aa， bb
        {
            cout << n << endl;
        }
    }
    return 0;
}

