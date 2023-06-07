package calculator.domain

class Calculator {

    /**
     * 추출한 문자열 계산
     */
    fun calculate(list: List<String>): Double {

        var result = list[0].toDouble()

        for (i in 1 until list.size step 2) {
            val operator = Operator.findOperate(list[i][0])
            result = operator.operate(result, list[i + 1].toDouble())
        }

        return result
    }
}
