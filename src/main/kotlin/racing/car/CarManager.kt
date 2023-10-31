package racing.car

import racing.rule.Rule

class CarManager {
    private val carList = mutableListOf<Car>()
    private val rule = Rule()

    fun createCarList(num: Int) {
        for (i in 0 until num) {
            carList.add(Car())
        }
    }

    fun moveCar() {
        carList.forEach { if (rule.isMove()) it.move() }
    }

    fun getCarPositionList(): List<Int> {
        val carPositionList = mutableListOf<Int>()

        carList.map { carPositionList.add(it.position) }

        return carPositionList
    }

    fun validateInputData(inputDAta: String) {
        validateEmpty(inputDAta)
        validateNumber(inputDAta)
        validateZero(inputDAta)
    }

    private fun validateEmpty(inputData: String) {
        // 공백을 입력했을 경우
        if (inputData.isEmpty()) {
            throw IllegalArgumentException("출전할 자동차 대수를 입력해 주세요.")
        }
    }

    private fun validateNumber(inputData: String) {
        // 숫자를 입력하지 않았을 경우
        if (inputData.toIntOrNull() == null) {
            throw NumberFormatException("출전할 자동차 대수를 잘못 입력하셨습니다.")
        }
    }

    private fun validateZero(inputData: String) {
        // 입력값에 0을 입력한 경우
        if (inputData.toInt() == 0) {
            throw IllegalArgumentException("출전할 자동차의 대수가 0 입니다.")
        }
    }
}
