package step2

class StringCalculator {
    val DELIMITER = " "

    fun calcaulte(s: String): Double {
        val deque = ArrayDeque(parse(s))
        while (deque.size != 1) {
            val x = deque.removeFirst()
            val op = getOperator(deque.removeFirst())
            val y = deque.removeFirst()
            deque.addFirst(op(x.toDouble(), y.toDouble()).toString())
        }
        return deque.first().toDouble()
    }

    fun parse(s: String?): List<String> {
        validateParam(s)
        return s!!.split(DELIMITER).toList()
    }

    private fun validateParam(s: String?) {
        if (s == null || s.trim().isEmpty()) {
            throw IllegalArgumentException("입력값이 null 이거나 빈 공백 문자입니다.")
        }
    }

    fun getOperator(s: String): (Double, Double) -> Double {
        return when (s) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "*" -> { x, y -> x * y }
            "/" -> { x, y -> x / y }
            else -> throw IllegalArgumentException("알 수 없는 연산자입니다.")
        }
    }
}