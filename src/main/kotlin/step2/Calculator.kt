package step2

class Calculator {
    companion object {
        fun calculate(string: String): Double {
            val list = StringParser.parse(string)
            val (head) = list
            var result = head.toDouble()
            for (i in 1 until list.size step 2) {
                val number = list[i + 1].toDouble()
                val operator: (Double, Double) -> Double = when (list[i]) {
                    "+" -> Operator.plus
                    "-" -> Operator.subtract
                    "*" -> Operator.multiply
                    "/" -> Operator.division
                    else -> throw IllegalAccessError("지원하지 않는 연산자")
                }
                result = operator(result, number)
            }
            return result
        }
    }
}
