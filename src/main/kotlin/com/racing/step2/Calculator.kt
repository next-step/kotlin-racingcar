package com.racing.step2

class Calculator {
    companion object {
        val operationList = listOf<String>("+", "-", "*", "/")
    }

    fun exec(exp: String): Int {
        val expressionList = exp.split(" ")

        validate(expressionList)

        // calc
        var result = 0
        var op = ""
        for (i in expressionList.indices) {
            if (i == 0) {
                result = expressionList[i].toInt()
                continue
            }

            if (i % 2 == 1) {
                op = expressionList[i]
            } else {
                if (op == "+") {
                    result += expressionList[i].toInt()
                } else if (op == "-") {
                    result -= expressionList[i].toInt()
                } else if (op == "*") {
                    result *= expressionList[i].toInt()
                } else if (expressionList[i].toInt() != 0) {
                    result /= expressionList[i].toInt()
                } else {
                    throw java.lang.IllegalArgumentException("0 으로 값을 나눌 수 없습니다")
                }
            }
        }

        // return result
        return result
    }
    private fun validate(expressionList: List<String>) {
        checkExpressionFormat(expressionList)
        checkExpressionOperateIndex(expressionList)
    }
}
