package racingcar.model

data class PositiveNumber(private var value: Int = 0) {

    init {
        validateNegativeNumber(this.value)
    }

    constructor(input: String) : this() {
        this.value = validateNegativeStringNumber(input)
    }

    fun plus(add: Int) {
        this.value += add
    }

    fun getPositiveNumber(): Int {
        return this.value
    }

    operator fun compareTo(other: PositiveNumber): Int =
        when {
            this.value > other.value -> 1
            this.value < other.value -> -1
            else -> 0
        }

    private fun validateNegativeNumber(input: Int) {
        require(MINIMUM_NUMBER <= input) { "$MINIMUM_NUMBER 보다 작은 수를 입력할 수 없습니다." }
    }

    private fun validateNegativeStringNumber(input: String): Int {
        val result = input.toIntOrNull()
        require(result != null) { "숫자가 아닌 값을 입력할 수 없습니다." }
        validateNegativeNumber(result)
        return result
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
    }
}
