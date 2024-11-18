package race

data class PositiveNumber(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다."))

    operator fun plus(other: PositiveNumber): PositiveNumber {
        return PositiveNumber(value + other.value)
    }

    fun isGreaterThanOrEqual(other: PositiveNumber): Boolean {
        return value >= other.value
    }

    companion object {
        val ONE: PositiveNumber = PositiveNumber(1)
    }
}
