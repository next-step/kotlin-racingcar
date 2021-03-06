package racingcar.game.vo

const val MAX_CAR_NAME = 5

data class GameParameter(val nameOfCars: List<String>, val numOfGame: Int) {
    init {
        nameOfCars.forEach {
            require(!it.isBlank()) { "자동차 이름은 blank 값이 될 수 없습니다." }
            require(it.length <= MAX_CAR_NAME) { "자동차 이름은 5자를 초과할 수 없습니다." }
        }
    }
}
