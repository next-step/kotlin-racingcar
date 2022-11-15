package racingcar.view

import racingcar.input.value.PlayTime
import racingcar.input.value.Racers

class InputView {
    companion object {
        private const val RACERS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val PLAY_TIME_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ERROR = "[ERROR] "

        fun inputRacers(): Array<String> {
            return try {
                println(RACERS_INPUT_MESSAGE)
                Racers(readln()).value.toTypedArray()
            } catch (e: Exception) {
                println(ERROR + e.message)
                inputRacers()
            }
        }

        fun inputPlayTime(): Int {
            return try {
                println(PLAY_TIME_INPUT_MESSAGE)
                PlayTime(readln().toInt()).value
            } catch (e: Exception) {
                println(ERROR + e.message)
                inputPlayTime()
            }
        }
    }
}
