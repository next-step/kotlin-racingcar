package step2

class StringCalculator {
    fun calcaulte(s: String): Double {
        ParamValidator.validateNotNull(s)
        ParamValidator.validateNonEmpty(s)

        val deque = ArrayDeque(StringParser().parse(s))
        while (deque.size != 1) {
            val x = deque.removeFirst()
            val op = BinaryOperator.getOperator(deque.removeFirst())
            val y = deque.removeFirst()
            deque.addFirst(op(x.toDouble(), y.toDouble()).toString())
        }
        return deque.first().toDouble()
    }
}