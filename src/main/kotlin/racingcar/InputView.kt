package racingcar

class InputView {

    fun setUp(numberOfCars: Int, numberOfLabs: Int): Setting {
        return Setting(passIfGreaterThanOne(numberOfCars), passIfGreaterThanOne(numberOfLabs))
    }

    fun setUp(numberOfCars: String? = askNumberOfCars(), numberOfLabs: String? = askNumberOfLabs()): Setting {
        return setUp(parseIntIfIntegerString(numberOfCars), parseIntIfIntegerString(numberOfLabs))
    }

    private fun askNumberOfCars(): String? {
        display("자동차 대수는 몇대인가요?")
        return readLine()
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

    private fun passIfGreaterThanOne(number: Int): Int {
        require(number >= 1) { "1보다 작은 정수를 입력할 수 없습니다" }
        return number
    }

    private fun display(message: String) {
        println(message)
    }
}
