package racingcar.view

class InputView {

    fun inputCarsNames(): List<String> {
        printInputCarNamesMessage()
        val input = readln()
        val carNamesString = input.split(CAR_NAME_DELIMITER)
        return carNamesString.map { it }.toList()
    }

    private fun printInputCarNamesMessage() {
        println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun inputRoundCount(): Int {
        printInputTryCountMessage()
        return readln().toInt()
    }

    private fun printInputTryCountMessage() {
        println("시도할 회수는 몇 회 인가요?")
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
