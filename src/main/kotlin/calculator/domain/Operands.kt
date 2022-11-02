package calculator.domain

import java.util.*

class Operands(private val operandQueue: Queue<Operand>) {

    fun pull(): Operand {
        return operandQueue.poll()
    }
}
