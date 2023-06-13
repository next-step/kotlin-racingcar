package step2

data class Expression(val operands: List<Int>, val operators: List<Operator>){
    init {
        require(operands.size == operators.size + 1) { "operand 개수는 항상 operator 보다 1개 더 많아야 합니다" }
    }
}
