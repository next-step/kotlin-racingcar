class CarManager {
    val carList: MutableList<Car> = mutableListOf()
    var tryCount: Int = 0

    fun add() {
        carList.add(Car())
    }

    fun move() {
        for (car in carList) {
            car.diceMove()
        }
    }
}
