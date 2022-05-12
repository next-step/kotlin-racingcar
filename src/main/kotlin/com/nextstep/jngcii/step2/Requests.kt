package com.nextstep.jngcii.step2

class Requests(
    val numbers: List<POperator>,
    val operators: List<Operator>
) {
    init {
        if (numbers.size - 1 != operators.size) {
            throw IllegalArgumentException("잘못된 계산식입니다.")
        }
    }
}
