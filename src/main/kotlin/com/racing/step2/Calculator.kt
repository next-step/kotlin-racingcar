package com.racing.step2

class Calculator {
    companion object {
        val operationList = listOf<String>("+", "-", "*", "/")
    }

    fun exec(exp: String): Int {
        // parsing
        val splitedExpressionList = exp.split(" ")
        // validating
        if (splitedExpressionList.size <= 2 || splitedExpressionList.size % 2 == 0) {
            throw IllegalArgumentException("식을 정확하게 입력해주세요")
        }

        for (index in splitedExpressionList.indices) {
            if (index % 2 != 0) {
                if (!Companion.operationList.contains(splitedExpressionList[index])) {
                    throw IllegalArgumentException("식을 정확하게 입력해주세요")
                }
            }
        }

        // calc
        var result = 0
        var op = ""
        for (i in splitedExpressionList.indices) {
            if (i == 0) {
                result = splitedExpressionList[i].toInt()
                continue
            }

            if (i % 2 == 1) {
                op = splitedExpressionList[i]
            } else {
                if (op == "+") {
                    result += splitedExpressionList[i].toInt()
                } else if (op == "-") {
                    result -= splitedExpressionList[i].toInt()
                } else if (op == "*") {
                    result *= splitedExpressionList[i].toInt()
                } else if (splitedExpressionList[i].toInt() != 0) {
                    result /= splitedExpressionList[i].toInt()
                } else {
                    throw java.lang.IllegalArgumentException("0 으로 값을 나눌 수 없습니다")
                }
            }
        }

        // return result
        return result
    }
}
