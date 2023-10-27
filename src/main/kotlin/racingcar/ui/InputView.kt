package racingcar.ui

private const val INPUT_COUNT_OF_RACER_MESSAGE = "자동차 대수는 몇 대인가요?"
private const val INPUT_COUNT_OF_RACING_MESSAGE = "시도할 횟수는 몇 회인가요?"

class InputView {
    companion object {
        fun inputCountOfRacer(): Int {
            println(INPUT_COUNT_OF_RACER_MESSAGE)
            return readln().toInt()
        }

        fun inputCountOfRacing(): Int {
            println(INPUT_COUNT_OF_RACING_MESSAGE)
            return readln().toInt()
        }
    }
}
