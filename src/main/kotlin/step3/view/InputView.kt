package step3.view

import step3.input.InputResultDto
import step3.input.value.NumberOfCars
import step3.input.value.PlayTime

class InputView {
    companion object {
        private const val CAR_NUMBER_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val PLAY_TIME_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ERROR = "[ERROR] "

        fun inputData(): InputResultDto {
            return try {
                InputResultDto(
                    NumberOfCars(inputCarNumber()),
                    PlayTime(inputPlayTime())
                )
            } catch (e: Exception) {
                println(ERROR + e.message)
                inputData()
            }
        }

        private fun inputCarNumber(): Int {
            println(CAR_NUMBER_INPUT_MESSAGE)
            return readln().toInt()
        }

        private fun inputPlayTime(): Int {
            println(PLAY_TIME_INPUT_MESSAGE)
            return readln().toInt()
        }
    }
}
