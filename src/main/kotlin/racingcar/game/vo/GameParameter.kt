package racingcar.game.vo

const val MIN_PARAM = 0

class GameParameter(val numOfCar: String?, val numOfGame: String?) {
    init {
        require(
            !numOfCar.isNullOrBlank() &&
                !numOfGame.isNullOrBlank()
        ) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
        try {
            require(
                numOfCar.toInt() > MIN_PARAM &&
                    numOfGame.toInt() > MIN_PARAM
            ) { "입력값은 1 이상이어야만 합니다." }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력 파라미터는 모두 정수형만 허용됩니다.")
        }
    }
}
