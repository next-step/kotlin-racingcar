package calculator

import calculator.enums.Operator
import calculator.util.regexForNumber
import calculator.util.regexForOperator

class CalculatorImpl : Calculator {
    override fun calculate(input: UserInput): Int {
        input.validate()

        val items: List<String> = input.inputString.split(" ")

        val numberList = mutableListOf<Int>()
        val operatorList = mutableListOf<String>()
        for (item in items) {
            when {
                regexForNumber.matches(item) -> numberList.add(item.toInt())
                regexForOperator.matches(item) -> operatorList.add(item)
            }
        }

        if (operatorList.isNullOrEmpty()) {
            throw IllegalArgumentException("계산식에 사칙연산 기호가 포함되어 있지 않습니다")
        }

        var result = Operator.find(operatorList.first()).operation(numberList[0], numberList[1])
        for (index in 1 until operatorList.size) {
            result = Operator.find(operatorList[index]).operation(result, numberList[index + 1])
        }
        return result
    }
}
