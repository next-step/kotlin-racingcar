package com.nextstep.jngcii.step2

interface Calculator {
    fun run(lhs: POperator, rhs: POperator, op: Operator): POperator
}
