package racingcar.car

class Car {
    private var point = 0

    fun move(x: Int): Car {
        point += x
        return this
    }

    fun getPoint(): Int {
        return point
    }
}
