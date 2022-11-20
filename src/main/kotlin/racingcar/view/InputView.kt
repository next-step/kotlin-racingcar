package racingcar.view

import racingcar.domain.Setting

class InputView {

    fun receiveSetting(nameOfCars: String? = askNameOfCars(), numberOfLab: String? = askNumberOfLab()): Setting {
        return Setting.byCarNames(splitByComma(nameOfCars), parseIntIfIntegerString(numberOfLab))
    }

    private fun askNameOfCars(): String? {
        display("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()
    }

    private fun splitByComma(nameOfCars: String?): List<String> {
        require(!nameOfCars.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다" }
        return nameOfCars.split(",")
    }

    private fun askNumberOfLab(): String? {
        display("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    private fun parseIntIfIntegerString(integerString: String?): Int {
        require(!integerString.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다" }
        requireNotNull(integerString.toIntOrNull()) { "입력된 문자는 정수여야 합니다" }
        return integerString.toInt()
    }

    private fun display(message: String) {
        println(message)
    }
}
