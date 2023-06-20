package step3.domain

interface CarMover {

    fun move(carList: List<Car>) {
        carList.forEach{ it.move() }
    }

    fun movable(): Boolean

}