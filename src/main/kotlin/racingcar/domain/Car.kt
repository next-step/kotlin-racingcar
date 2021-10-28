package racingcar.domain

class Car(
    val carName: String,
    var distance: Int = 0
) {

    init {
        require(carName.length <= NAME_LENGTH_LIMIT) { CAR_NAME_LENGTH_OVER }
    }

    fun forward(randomNumber: Int) {
        if (randomNumber >= MOVE_SUCCESS) distanceIncrease()
    }

    private fun distanceIncrease() {
        distance++
    }

    companion object {
        private const val MOVE_SUCCESS = 4
        private const val NAME_LENGTH_LIMIT = 5
        private const val CAR_NAME_LENGTH_OVER = "자동차 이름의 길이는 5자를 초과할 수 없습니다."
    }
}
