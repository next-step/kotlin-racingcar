package racingcar.etc

class NonNegative {

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val FORWARD_VALUE = 1
    }

    private var value: Number

    constructor() {
        this.value = 0
    }

    constructor(text: String) {
        this.value = StringAsNumber(text)
        validateNegative()
    }

    fun toInt(): Int {
        return this.value.toInt()
    }

    fun plus() {
        this.value = this.value.toInt().plus(FORWARD_VALUE)
    }

    private fun validateNegative() {
        require(MINIMUM_NUMBER <= this.value.toInt()) { "$MINIMUM_NUMBER 보다 작은 수를 입력할 수 없습니다." }
    }
}
