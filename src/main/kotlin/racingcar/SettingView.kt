package racingcar

// Int 입력시 -> 유효성 검사만, 미 입력시 default 값으로 실행
// String 입력시 -> String 유효성 검사 -> Int 유효성 검사
// 미 입력시 -> readLine

class SettingView {

    fun setUp(numberOfCars: Int, numberOfLabs: Int): Setting {
        return Setting(validateInteger(numberOfCars), validateInteger(numberOfLabs))
    }

    fun setUp(numberOfCars: String? = askNumberOfCars(), numberOfLabs: String? = askNumberOfLabs()): Setting {
        return Setting(
            validateInteger(parseIntegerString(numberOfCars)),
            validateInteger(parseIntegerString(numberOfLabs))
        )
    }

    private fun askNumberOfCars(): String? {
        display("자동차 대수는 몇대인가요?")
        return readLine()
    }

    private fun askNumberOfLabs(): String? {
        display("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    private fun parseIntegerString(inputText: String?): Int {
        require(!inputText.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다" }
        requireNotNull(inputText.toIntOrNull()) { "입력된 문자는 정수여야 합니다" }
        return inputText.toInt()
    }

    private fun validateInteger(number: Int): Int {
        require(number >= 1) { "1보다 작은 정수를 입력할 수 없습니다" }
        return number
    }

    private fun display(message: String) {
        println(message)
    }
}
