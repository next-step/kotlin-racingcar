package calculator.operator

import calculator.operand.Operand

object DivideOperator : Operator {
    override fun operate(left: Operand, right: Operand): Operand {
        require(right != Operand(0.0)) { "0으로 나눌 수 없습니다." }
        return left / right
    }
}
