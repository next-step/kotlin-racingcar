package racingcar.domain

import racingcar.ui.InputView
import racingcar.ui.ResultView

object GameManager {

    private const val INPUT_BOUNDED_NUMBER = 0

    fun racing() {
        val numberOfCars = validateNegativeStringNumber(InputView.numberOfCars())
        val numberOfRaces = validateNegativeStringNumber(InputView.numberOfRaces())
        val cars = Cars(numberOfCars)
        println("\n실행 결과")
        for (race in 1..numberOfRaces) {
            cars.racing()
            ResultView.racing(cars.racingResult())
        }
    }

    fun validateNegativeNumber(input: Int) {
        require(INPUT_BOUNDED_NUMBER <= input) { "$INPUT_BOUNDED_NUMBER 보다 작은 수를 입력할 수 없습니다." }
    }

    fun validateNegativeStringNumber(input: String): Int {
        val result = input.toIntOrNull()
        require(result != null) { "숫자가 아닌 값을 입력할 수 없습니다." }
        validateNegativeNumber(result)
        return result
    }
}
