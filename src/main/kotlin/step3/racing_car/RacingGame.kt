package step3.racing_car

/**
 * 자동차 경주 게임
 * */

const val MIN_RANDOM_VALUE = 0
const val MAX_RANDOM_VALUE = 9

object RacingGame {

    /**
     * 게임 시작
     * */
    fun run(numberCars: String, roundCnt: String, roundFinishListener: (List<Car>) -> Unit) {

        errorCheck(numberCars)
        errorCheck(roundCnt)

        var carList: List<Car> = List(numberCars.toInt()) { Car() }

        repeat(roundCnt.toInt()) {
            carList = playRound(carList)
            roundFinishListener(carList)
        }
    }

    private fun errorCheck(inputStr: String?) {
        require(inputStr?.isNotEmpty() == true && Int.MAX_VALUE.toString().length >= inputStr.length && inputStr.toIntOrNull() != null && inputStr.toInt() > 0) {
            "Invalid Expression: $inputStr"
        }
    }

    private fun playRound(carList: List<Car>): List<Car> {
        return carList.map {
            it.move((MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random())
            it
        }
    }
}