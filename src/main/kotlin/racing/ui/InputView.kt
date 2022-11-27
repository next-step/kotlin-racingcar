package racing.ui

private const val INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
private const val INPUT_NAMES_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val INPUT_COUNT_OF_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?"

object InputView {

    fun inputNumberOfCars(): Int {
        println(INPUT_NUMBER_OF_CARS_MESSAGE)
        return readln().toInt()
    }

    fun inputNamesOfCars(): String {
        println(INPUT_NAMES_OF_CARS_MESSAGE)
        return readln()
    }

    fun inputCountOfTry(): Int {
        println(INPUT_COUNT_OF_TRY_MESSAGE)
        return readln().toInt()
    }
}
