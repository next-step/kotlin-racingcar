package calculator.study

import calculator.dto.AbstractSyntaxTree
import java.util.Deque
import java.util.LinkedList

class CalculateMachine private constructor(private val abstractSyntaxTree: AbstractSyntaxTree) {

    private val numberQueue: Deque<Operand> = LinkedList(abstractSyntaxTree.numbers)

    fun calculate(): Operand {
        abstractSyntaxTree.operators.forEach {
            val leftOperand = numberQueue.poll()
            val rightOperand = numberQueue.poll()
            numberQueue.addFirst(it.apply(leftOperand, rightOperand))
        }
        return numberQueue.poll()
    }

    companion object {
        fun compile(abstractSyntaxTree: AbstractSyntaxTree): CalculateMachine = CalculateMachine(abstractSyntaxTree)
    }
}
