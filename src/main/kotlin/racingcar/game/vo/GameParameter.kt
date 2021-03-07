package racingcar.game.vo

const val DELIMITER = ","
const val MIN_PARAM = 0
const val MAX_CAR_NAME = 5

data class GameParameter(val nameOfCars: List<String>, val numOfGame: Int) {
    companion object {
        fun initParameter(nameOfCar: String?, numOfGame: String?): GameParameter {
            return GameParameter(checkNameOfCar(nameOfCar), checkNumOfGame(numOfGame))
        }

        private fun checkNameOfCar(nameOfCar: String?): List<String> {
            require(!nameOfCar.isNullOrEmpty()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
            val nameOfCars = nameOfCar.split(DELIMITER)
            nameOfCars.forEach {
                require(!it.isBlank()) { "자동차 이름은 blank 값이 될 수 없습니다." }
                require(it.length <= MAX_CAR_NAME) { "자동차 이름은 5자를 초과할 수 없습니다." }
            }
            return nameOfCars
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
}
