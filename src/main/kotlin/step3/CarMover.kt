package step3

interface CarMover {

    fun move(carList: List<Car>) {
        carList.forEach{ it.move() }
    }

    fun movable(): Boolean

}