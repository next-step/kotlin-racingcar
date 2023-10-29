package racingcar

class Car(
    val carName: String,
    val position: Int = 0
) {

    private val name: String = carName

    fun move(random: Int): Car {
        if (isMove(random)) return Car(name, position + 1)
        return this
    }

    private fun isMove(random: Int): Boolean {
        return random >= 4
    }
}
