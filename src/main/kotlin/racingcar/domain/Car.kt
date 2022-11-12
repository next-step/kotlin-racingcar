package racingcar.domain

class Car(
    var route: Int = 0
) {
    fun move() {
        this.route += 1
    }

    companion object {
        fun generateCar(count: Int) = buildList {
            repeat(count) { add(Car()) }
        }
    }
}
