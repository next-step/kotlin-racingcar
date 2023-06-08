package com.racing.step2

object Calculator {
    fun exec(exp: String): Int {
        val expressionList = exp.split(" ")

        checkExpressionFormat(expressionList)

        var indexPointer = 2
        var result = expressionList[0].toInt()
        while (indexPointer < expressionList.size) {
            result = operate(result, expressionList[indexPointer].toInt(), expressionList[indexPointer - 1])
            indexPointer += 2
        }

        return result
    }

    private fun operate(a: Int, b: Int, op: String): Int {
        return when (op) {
            Operator.PLUS.op -> Operator.PLUS.run(a, b)
            Operator.MINUS.op -> Operator.MINUS.run(a, b)
            Operator.CROSS.op -> Operator.CROSS.run(a, b)
            Operator.DIVIDE.op -> Operator.DIVIDE.run(a, b)
            else -> throw IllegalArgumentException("부호가 잘 못 된 로직입니다")
        }
    }
}
