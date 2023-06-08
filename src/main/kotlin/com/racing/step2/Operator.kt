package com.racing.step2

enum class Operator(
    val op: String,
    val run: (Int, Int) -> Int
) {
    PLUS("+", { x: Int, y: Int -> x + y }),
    MINUS("-", { x: Int, y: Int -> x - y }),
    CROSS("*", { x: Int, y: Int -> x * y }),
    DIVIDE("/", { x: Int, y: Int -> if (y != 0) x / y else throw IllegalArgumentException("0 으로 나눌 수는 없습니다") });
}
