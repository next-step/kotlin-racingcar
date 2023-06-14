package study.racing.inputview

import java.lang.IllegalArgumentException

class CarNameBasedInputView : InputView<CarNameBasedInputView.CarNameBasedRacingInputResult> {

    override fun receive(): CarNameBasedRacingInputResult {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val carNames = readLine()!!.toString()
        validateCarNamesInput(carNames)
        println("시도할 횟수는 몇 회인가요?")
        val numOfAttempt = readLine()!!.toInt()

        return CarNameBasedRacingInputResult(
            carNames = carNames.split(","),
            numOfAttempt = numOfAttempt
        )
    }

    private fun validateCarNamesInput(carNames: String) {
        if (carNames.isBlank()) {
            throw IllegalArgumentException("최소 한 개의 차량을 입력해주세요")
        }
    }

    data class CarNameBasedRacingInputResult(
        val carNames: List<String>,
        val numOfAttempt: Int
    )
}
