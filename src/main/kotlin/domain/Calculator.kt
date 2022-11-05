package domain

import constant.Constants.Companion.ADDITION
import constant.Constants.Companion.DIVISION
import constant.Constants.Companion.MULTIPLICATION
import constant.Constants.Companion.ROUND
import constant.Constants.Companion.SUBTRACT
import java.lang.IllegalArgumentException
import kotlin.math.round

class Calculator {
    fun calculate(inputData: CalculationExpression): Double {
        var operandIndex: Int
        var result = inputData.operand.operandList[0]?.toDouble()!!
        try {
            for (operatorIndex in 0 until inputData.operator.operatorList.size) {
                operandIndex = operatorIndex + 1
                if (inputData.operator.operatorList[operatorIndex] == ADDITION) {
                    result = addition(result.toString(), inputData.operand.operandList[operandIndex])
                    continue
                }

                if (inputData.operator.operatorList[operatorIndex] == SUBTRACT) {
                    result = subtract(result.toString(), inputData.operand.operandList[operandIndex])
                    continue
                }

                if (inputData.operator.operatorList[operatorIndex] == DIVISION) {
                    result = division(result.toString(), inputData.operand.operandList[operandIndex])
                    continue
                }

                if (inputData.operator.operatorList[operatorIndex] == MULTIPLICATION) {
                    result = multiplication(result.toString(), inputData.operand.operandList[operandIndex])
                    continue
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            // "1 + "와 같이 마지막 피연산자가 없을 경우에 대한 처리
            println("Empty Operand")
            throw IllegalArgumentException()
        }
        return result
    }

    fun addition(number1: String?, number2: String?): Double {
        return round((number1?.toDouble()!! + number2?.toDouble()!!) * ROUND) / ROUND
    }

    fun subtract(number1: String?, number2: String?): Double {
        return round((number1?.toDouble()!! - number2?.toDouble()!!) * ROUND) / ROUND
    }

    fun division(number1: String?, number2: String?): Double {
        if (number2 == "0") {
            throw IllegalArgumentException()
        }
        return round((number1?.toDouble()!! / number2?.toDouble()!!) * ROUND) / ROUND
    }

    fun multiplication(number1: String?, number2: String?): Double {
        return round((number1?.toDouble()!! * number2?.toDouble()!!) * ROUND) / ROUND
    }
}
