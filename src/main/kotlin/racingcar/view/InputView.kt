package racingcar.view

class InputView {
    companion object {
        private const val RACERS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val PLAY_TIME_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ERROR = "[ERROR] "

        fun inputRacers(): String {
            println(RACERS_INPUT_MESSAGE)
            return readln()
        }

        fun inputPlayTime(): Int {
            println(PLAY_TIME_INPUT_MESSAGE)
            return readln().toInt()
        }

        fun printError(message: String) {
            println(ERROR + message)
        }
    }
}
