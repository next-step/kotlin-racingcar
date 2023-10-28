package calculator

import calculator.enums.Operator
import calculator.util.regexForNumber
import calculator.util.regexForOperator

class CalculatorImpl : Calculator {
    override fun calculate(input: UserInput): Int {
        input.validate()

        val items: List<String> = input.inputString!!.split(" ")

        val numberList = mutableListOf<Int>()
        val operatorList = mutableListOf<String>()
        for (i in items) {
            if (regexForNumber.matches(i)) {
                numberList.add(i.toInt())
            }

            if (regexForOperator.matches(i)) {
                operatorList.add(i)
            }
        }
        if (operatorList.isNullOrEmpty()) {
            throw IllegalArgumentException("계산식에 사칙연산 기호가 포함되어 있지 않습니다")
        }

        var sum = 0
        for (i in operatorList) {
            if (sum == 0) {
                sum = Operator.find(i).sum(numberList[0], numberList[1])
                continue
            }
            sum = Operator.find(i).sum(sum, numberList[operatorList.indexOf(i) + 1])
        }
        return sum
    }
}
