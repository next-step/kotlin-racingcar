package calculator.domain

import calculator.domain.vo.Term

interface Calculator {
    fun calculate(input: String): Term
}
