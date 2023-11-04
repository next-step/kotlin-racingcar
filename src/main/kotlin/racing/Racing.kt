package racing

import racing.car.Car
import racing.car.CarOperation

class Racing(private val carOperations: CarOperation) {

    private val racingResultList = mutableListOf<List<Car>>()

    fun startRacing(racingCnt: Int) {
        for (i in 0 until racingCnt) {
            carOperations.moveCar()
            saveRacingResult()
        }
    }

    fun getRacingResultList() = racingResultList.toList()

    private fun saveRacingResult() {
        racingResultList.add(carOperations.getCarList())
    }

    fun validateInputData(inputDAta: String) {
        validateEmpty(inputDAta)
        validateNumber(inputDAta)
        validateZero(inputDAta)
    }

    private fun validateEmpty(inputData: String) {
        // 공백을 입력했을 경우
        if (inputData.isEmpty()) {
            throw IllegalArgumentException("시도할 횟수를 입력해 주세요.")
        }
    }

    private fun validateNumber(inputData: String) {
        // 숫자를 입력하지 않았을 경우
        if (inputData.toIntOrNull() == null) {
            throw NumberFormatException("시도할 횟수를 잘못 입력하셨습니다.")
        }
    }

    private fun validateZero(inputData: String) {
        // 입력값에 0을 입력한 경우
        if (inputData.toInt() == 0) {
            throw IllegalArgumentException("시도할 횟수가 0 입니다.")
        }
    }
}
