package study.racingcar.domain

class Car(val name: CarName) {

    var position = 0
        private set

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }
}
