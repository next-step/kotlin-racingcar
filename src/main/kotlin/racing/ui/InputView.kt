package racing.ui

import racing.model.CarInput

class InputView {
    fun getInput(): CarInput {
        val carInput = CarInput(getNameOfCars(), getNumberOfTimes())
        println()

        return carInput
    }

    private fun getNameOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readlnOrNull() ?: throw IllegalArgumentException()
        return carNames.split(NAME_DELIMITER)
    }

    private fun getNumberOfTimes(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException()
    }

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
