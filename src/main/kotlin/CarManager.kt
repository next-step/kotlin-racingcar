class CarManager {
    val carList: MutableList<Car> = mutableListOf()
    var tryCount: Int = 0

    fun add() {
        carList.add(Car())
    }

    fun move(tryCount: Int) {
        this.tryCount = tryCount

        for (car in carList) {
            car.diceMove()
        }
    }
}
