package com.nextstep.jngcii.step2

interface Calculator {
    fun run(left: Operand, right: Operand, operator: Operator): Operand
}
