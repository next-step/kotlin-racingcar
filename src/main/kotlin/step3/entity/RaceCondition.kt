package step3.entity

import java.lang.NumberFormatException

class RaceCondition private constructor(
    val numberOfCars: Int,
    val numberOfLabs: Int,
) {
    companion object {
        fun of(numberOfCars: String?, numberOfLabs: String?): RaceCondition =
            RaceCondition(validateNumbers(numberOfCars), validateNumbers(numberOfLabs))

        private fun validateNumbers(number: String?): Int {
            require(!number.isNullOrBlank()) { "입력은 반드시 필요합니다. 숫자를 입력해주세요." }
            val intValue = try {
                number.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("숫자만 입력해주세요.")
            }
            require(intValue > 0) { "숫자는 반드시 양수여야 합니다." }
            return intValue
        }
    }
}
