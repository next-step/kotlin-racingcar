package racingcar.game.ui

import racingcar.game.vo.GameParameter

const val MIN_PARAM = 0
const val DELIMITER = ","

class InputConsole(val carNameReader: () -> String?, val numOfGameReader: () -> String?) {

    fun run(): GameParameter {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameOfCar = carNameReader()
        println("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = numOfGameReader()

        require(!nameOfCar.isNullOrEmpty()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }

        return GameParameter(nameOfCar.split(DELIMITER), checkNumOfGame(numOfGame))
    }

    private fun checkNumOfGame(numOfGame: String?): Int {
        require(!numOfGame.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
        try {
            require(numOfGame.toInt() > MIN_PARAM) { "입력값은 1 이상이어야만 합니다." }
            return numOfGame.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력 파라미터는 모두 정수형만 허용됩니다.")
        }
    }
}
