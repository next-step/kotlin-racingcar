package racingcar.game.vo

const val DELIMITER = ","
const val MIN_PARAM = 0

data class GameParameter(val nameOfCars: List<String>, val numOfGame: Int) {
    companion object {
        fun initParameter(nameOfCar: String?, numOfGame: String?): GameParameter {
            return GameParameter(parseNameOfCar(nameOfCar), parseNumOfGame(numOfGame))
        }

        private fun parseNameOfCar(nameOfCar: String?): List<String> {
            require(!nameOfCar.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
            return nameOfCar.split(DELIMITER)
        }

        private fun parseNumOfGame(numOfGame: String?): Int {
            require(!numOfGame.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
            try {
                val numOfGameInt: Int = numOfGame.toInt()
                require(numOfGameInt > MIN_PARAM) { "입력값은 1 이상이어야만 합니다." }
                return numOfGameInt
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("입력 파라미터는 모두 정수형만 허용됩니다.")
            }
        }
    }
}
