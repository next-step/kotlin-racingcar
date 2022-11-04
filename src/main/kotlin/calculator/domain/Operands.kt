package calculator.domain

import java.util.*

class Operands(private val operandQueue: Queue<Operand>) {

    fun poll(): Operand {
        return operandQueue.poll()
    }
}
