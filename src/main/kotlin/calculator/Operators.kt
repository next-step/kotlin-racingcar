package calculator

import java.util.Deque

private const val CALCULABLE = 1

class Operators {

    val operators : ArrayDeque<Operator> = ArrayDeque();


    fun add(operator:String){
        if (!Operator.isOperator(operator)){
            throw IllegalArgumentException("유효한 연산자가 아닙니다.");
        }
        if (operators.size >= CALCULABLE){
            throw IllegalArgumentException("유효하지 않은 입력값입니다.")
        }
        Operator.valueOf(operator = operator)?.let {
            operators.add(it)
        };
    }

    fun getOperator() = operators.removeFirst()

    fun isCalculable(): Boolean = this.operators.size == CALCULABLE
}
