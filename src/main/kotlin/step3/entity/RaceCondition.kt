package step3.entity

class RaceCondition private constructor(
    val nameOfCars: List<String>,
    val numberOfLabs: Int,
) {
    companion object {
        private const val DELIMITER = ","

        fun of(nameOfCars: String?, numberOfLabs: String?): RaceCondition =
            RaceCondition(validateString(nameOfCars, DELIMITER), validateNumbers(numberOfLabs))

        private fun validateNumbers(number: String?): Int {
            require(!number.isNullOrBlank()) { "입력은 반드시 필요합니다. 숫자를 입력해주세요." }
            val intValue = number.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력해주세요.")
            require(intValue > 0) { "숫자는 반드시 양수여야 합니다." }
            return intValue
        }

        private fun validateString(nameOfCars: String?, delimiter: String): List<String> {
            require(!nameOfCars.isNullOrBlank()) { "입력은 반드시 필요합니다. ,로 구분되는 자동차 이름을 입력해주세요." }
            return nameOfCars.split(delimiter)
        }
    }
}
