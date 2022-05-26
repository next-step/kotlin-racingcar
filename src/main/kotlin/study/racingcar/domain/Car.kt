package study.racingcar.domain

class Car(position: Int = 0) {

    var position = position
        private set

    fun move(condition: Int): Int {
        if (condition >= 4) {
            position++
        }

        return position
    }
}
