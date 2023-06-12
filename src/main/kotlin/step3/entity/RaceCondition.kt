package step3.entity

class RaceCondition private constructor(
    val nameOfCars: List<String>,
    val numberOfLabs: Int,
) {
    companion object {
        private const val DELIMITER = ","

        fun of(nameOfCars: String, numberOfLabs: String): RaceCondition =
            RaceCondition(validateString(nameOfCars), validateNumbers(numberOfLabs))

        private fun validateNumbers(number: String): Int {
            require(number.isNotBlank()) { "입력은 반드시 필요합니다. 숫자를 입력해주세요." }
            val intValue = number.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력해주세요.")
            require(intValue > 0) { "숫자는 반드시 양수여야 합니다." }
            return intValue
        }

        private fun validateString(nameOfCars: String): List<String> {
            require(nameOfCars.isNotBlank()) { "입력은 반드시 필요합니다. ,로 구분되는 자동차 이름을 입력해주세요." }
            require(nameOfCars.length <= 5) { "자동차의 이름은 5자를 초과할 수 없습니다." }
            return nameOfCars.split(DELIMITER)
        }
    }
}
