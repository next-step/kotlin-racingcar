package racingcar

class Car(
    carName: String,
    val position: Int = 0
) {

    init {
        require(carName.carNameCheck()) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    val name: String = carName

    fun move(value: Int): Car {
        if (isMove(value)) return Car(name, position + 1)
        return this
    }

    private fun isMove(random: Int): Boolean {
        return random >= 4
    }

    private fun String.carNameCheck(): Boolean {
        return this.length <= 5
    }
}
