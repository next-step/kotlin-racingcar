package racing.v2.console

import racing.v2.domain.Car
import racing.v2.domain.CarGame

object InputView {
    private const val CAR_COUNT_ERROR_MESSAGE = "자동차 이름을 쉼표(,) 기준으로 구분해서 입력해주세요."
    private const val TRY_COUNT_ERROR_MESSAGE = "시도할 횟수는 숫자로 입력해주세요."
    private const val INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_TRY_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?"

    fun createCarGame(carsStr: String?, tryCountStr: String?): CarGame {
        val cars: List<Car> = validateCars(carsStr)
        val tryCount: Int = validateTryCount(tryCountStr)

        return CarGame(cars, tryCount)
    }

    private fun validateCars(carsStr: String?): List<Car> {
        return carsStr?.split(",")?.map { name -> Car(name) }
            ?: throw IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE)
    }

    private fun validateTryCount(tryCountStr: String?): Int {
        return tryCountStr?.toIntOrNull() ?: throw IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE)
    }

    fun printCarNamesPrompt() {
        println(INPUT_CAR_NAMES_GUIDE)
    }

    fun printTryCountPrompt() {
        println(INPUT_TRY_COUNT_GUIDE)
    }

    fun getUserInput(): String? {
        return readlnOrNull()
    }
}
