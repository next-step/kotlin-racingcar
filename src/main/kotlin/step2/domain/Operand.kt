package step2.domain

data class Operand(val operand: Int) {
    val value: Int = operand

    init {
        require(operand >= 0) { "음수는 입력할 수 없습니다." }
    }
}
