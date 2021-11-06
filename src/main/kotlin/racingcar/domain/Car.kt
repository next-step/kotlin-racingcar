package racingcar.domain

class Car {

    private var distance: Int = 0

    fun move(number: Int): Int {
        if (number >= MOVE_NUMBER ) {
            distance++
        }
        return distance
    }

    companion object {
        const val MOVE_NUMBER = 4
    }
}