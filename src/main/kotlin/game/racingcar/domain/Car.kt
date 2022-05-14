package game.racingcar.domain

class Car {
    var position: Int = 0

    fun move(): Int {
        position += 1
        return position
    }
}
