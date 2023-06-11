package study.step2

import java.lang.IllegalArgumentException

class Expression(
    private val tokens: List<String>
) {
    fun calculate(): Long {
        val numQueue = ArrayDeque<Long>()
        val opQueue = ArrayDeque<Operator>()

        fillQueuesWithTokens(numQueue, opQueue)
        compute(numQueue, opQueue)

        return numQueue.first()
    }

    private fun fillQueuesWithTokens(numQueue: ArrayDeque<Long>, opQueue: ArrayDeque<Operator>) {
        tokens.forEachIndexed { idx, curr ->
            if (idx % 2 == 0) {
                numQueue.add(tokenToLong(curr))
            } else {
                opQueue.add(Operator.ofCode(curr)!!)
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

    private fun tokenToLong(token: String): Long {
        return token.toLongOrNull() ?: throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
    }
}
