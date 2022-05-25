package study.racingcar.domain

class Car(var position: Int = 0) {

    fun move(condition: Int): Int {
        if (condition >= 4) {
            position++
        }

        return position
    }
}
