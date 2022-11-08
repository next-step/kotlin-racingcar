package step2.domain

class Operand(operand: Int) {
    val value: Int = operand

    init {
        require(operand >= 0) { "음수는 입력할 수 없습니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
