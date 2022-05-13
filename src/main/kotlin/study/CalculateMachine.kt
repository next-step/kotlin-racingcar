package study

import dto.AST
import java.util.Deque
import java.util.LinkedList

class CalculateMachine(private val ast: AST) {

    private val numberQueue: Deque<Operand> = LinkedList(ast.numbers)

    init {
        require((ast.operators.size + 1) == this.numberQueue.size)
    }

    fun calculate(): Operand {
        ast.operators.forEach {
            val leftOperand = numberQueue.poll()
            val rightOperand = numberQueue.poll()
            this.numberQueue.addFirst(it.apply(leftOperand, rightOperand))
        }
        return numberQueue.poll()
    }
}
