package racingcar

private const val MAXIMUM_WORD_COUNT = 5

class InputView {

    fun receiveSetting(nameOfCars: List<String>, numberOfLabs: Int): Setting {
        return Setting(passIfNameLengthBetweenOneAndFive(nameOfCars), passIfEqualsOrGreaterThanOne(numberOfLabs))
    }

    fun receiveSetting(nameOfCars: String? = askNumberOfCars(), numberOfLabs: String? = askNumberOfLabs()): Setting {
        return receiveSetting(parseCarNameByComma(nameOfCars), parseIntIfIntegerString(numberOfLabs))
    }

    private fun askNumberOfCars(): String? {
        display("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()
    }

    private fun parseCarNameByComma(nameOfCars: String?): List<String> {
        require(!nameOfCars.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다" }
        return nameOfCars.split(",")
    }

    private fun passIfNameLengthBetweenOneAndFive(nameOfCars: List<String>): List<String> {
        nameOfCars.forEach { name ->
            checkNameLengthBetweenOneAndFive(name)
        }
        return nameOfCars
    }

    private fun checkNameLengthBetweenOneAndFive(name: String) {
        require(name.isNotBlank()) { ",로 분리된 값이 공백, 빈 문자열일 수 없습니다" }
        require(name.length <= MAXIMUM_WORD_COUNT) { "자동차 이름은 다섯자를 초과할 수 없습니다" }
    }

    private fun askNumberOfLabs(): String? {
        display("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    private fun parseIntIfIntegerString(integerString: String?): Int {
        require(!integerString.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다" }
        requireNotNull(integerString.toIntOrNull()) { "입력된 문자는 정수여야 합니다" }
        return integerString.toInt()
    }

    private fun passIfEqualsOrGreaterThanOne(number: Int): Int {
        require(number >= 1) { "1보다 작은 정수를 입력할 수 없습니다" }
        return number
    }

    private fun display(message: String) {
        println(message)
    }
}
