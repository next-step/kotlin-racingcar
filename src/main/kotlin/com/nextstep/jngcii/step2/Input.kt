package com.nextstep.jngcii.step2

import com.nextstep.jngcii.step2.vo.Number
import com.nextstep.jngcii.step2.vo.Operator

class Input(
    val numbers: List<Number>,
    val operators: List<Operator>
) {
    init {
        if (numbers.size - 1 != operators.size) {
            throw IllegalArgumentException("잘못된 계산식입니다.")
        }
    }
}
