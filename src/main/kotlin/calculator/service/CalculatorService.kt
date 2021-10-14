package calculator.service

import calculator.domain.vo.Term

interface CalculatorService {
    fun execute(input: String?): Term
}
