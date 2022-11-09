package racingcar.domain

class Car : Moveable {

    var currentPosition: Int = 0

    override fun go() {
        currentPosition++
    }

    override fun stop() {
        currentPosition
    }

    companion object {
        fun registerCars(numberOfCars: Int): Array<Car> {
            require(numberOfCars != 0) { "0대의 차로는 시작할 수 없습니다." }
            return Array(numberOfCars) { Car() }
        }

        fun Car.move(): Int {
            Gear.drive(this)
            return this.currentPosition
        }
    }
}
