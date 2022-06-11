package study.racingCar.domain

class Car(val carName: String, var mileage: Int = 0) {
    init {
        require(carName.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
        require(!carName.isNullOrBlank()) { "자동차 이름은 한 글자 이상이어야 합니다." }
    }

    fun tryMove(engineStatus: Int = (0..9).random()): Car {
        if (engineStatus >= MOVE_CONDITION) {
            mileage++
        }
        return this
    }

    companion object {
        const val MOVE_CONDITION = 4
        const val MAX_NAME_LENGTH = 5
    }
}
