package racingcar.car

class Car {
    var point = 0

    fun move(x: Int): Car {
        point += x
        return this
    }
}
