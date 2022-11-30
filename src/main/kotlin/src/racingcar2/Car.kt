package src.racingcar2

class Car(
    var position: Int = 0
) {

    fun move(moveCondition: Int): Car {
        if (moveCondition >= 4) this.position++
        return this
    }
}
