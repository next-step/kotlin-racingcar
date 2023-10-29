package racingcar.model

class NaturalNumber(val number: Int) {

    init {
        validateNumber(number)
    }

    private fun validateNumber(number: Int) {
        require(isNaturalNumber(number)) { "자연수는 1이상이어야 합니다." }
    }

    private fun isNaturalNumber(number: Int): Boolean {
        return number > 0
    }

    companion object {
        fun createNaturalNumber(number: Int): NaturalNumber {
            return NaturalNumber(number)
        }
    }
}
