package racingCar.domain

class Car(val name: String, var distance: Int = 0) {

    init {
        require(name.length <= MAX_CAR_NAME) { "차 이름 5글자 이상 불가" }
    }

    fun changeStateRacingCar(isMove: Boolean) {
        if (isMove) move()
    }

    private fun move() {
        distance += 1
    }

    companion object {
        private const val MAX_CAR_NAME = 5
    }
}
