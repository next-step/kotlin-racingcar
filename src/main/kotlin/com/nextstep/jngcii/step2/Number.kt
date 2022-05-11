package com.nextstep.jngcii.step2

class Number(
    input: String,
    val isEnd: Boolean = false,
) {
    val value: Int

    init {
        try {
            value = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자형만 계산 가능합니다.")
        }
    }
}
