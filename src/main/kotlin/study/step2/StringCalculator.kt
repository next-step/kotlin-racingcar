package study.step2

import java.lang.IllegalArgumentException

class StringCalculator {
    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank())

        val tokens = tokenizeInput(input)
        validateTokens(tokens)

        val numQueue = ArrayDeque<Long>()
        val opQueue = ArrayDeque<Operator>()

        fillQueuesWithTokens(tokens, numQueue, opQueue)
        compute(numQueue, opQueue)

        return numQueue.first()
    }

    private fun tokenizeInput(input: String): List<String> {
        return input.split(" ")
    }

    private fun validateTokens(tokens: List<String>) {
        if (!isLongTypeToken(tokens.first()) || !isLongTypeToken(tokens.last())) {
            throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
        }
    }

    private fun isLongTypeToken(token: String): Boolean {
        return token.toLongOrNull() != null
    }

    private fun tokenToLong(token: String): Long {
        return token.toLongOrNull() ?: throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
    }

    private fun fillQueuesWithTokens(tokens: List<String>, numQueue: ArrayDeque<Long>, opQueue: ArrayDeque<Operator>) {
        tokens.forEachIndexed { idx, curr ->
            if (idx % 2 == 0) {
                numQueue.add(tokenToLong(curr))
            } else {
                opQueue.add(Operator.ofCode(curr))
            }
        }
    }

    private fun compute(numQueue: ArrayDeque<Long>, opQueue: ArrayDeque<Operator>) {
        while (opQueue.isNotEmpty()) {
            val lhs = numQueue.removeFirst()
            val rhs = numQueue.removeFirst()
            val op = opQueue.removeFirst()
            numQueue.addFirst(op.operation(lhs, rhs))
        }
    }

    enum class Operator(val code: String, val operation: (Long, Long) -> Long) {
        SUM("+", { x, y -> x + y }),
        SUBTRACT("-", { x, y -> x - y }),
        MULTIPLY("*", { x, y -> x * y }),
        DIVISION("/", { x, y -> x / y })
        ;

        companion object {
            fun ofCode(code: String) =
                values().find { it.code == code }
                    ?: throw IllegalArgumentException("$code 는 유효하지 않은 연산자입니다")
        }
    }
}
