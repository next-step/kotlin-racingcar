package racingcar

class Car(val position: Int = 0) {

    fun move(random: Int): Car {
        if (isMove(random)) return Car(position + 1)
        return this
    }

    private fun isMove(random: Int): Boolean {
        return random >= 4
    }
}
