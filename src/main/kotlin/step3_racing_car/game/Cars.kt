package step3_racing_car.game

object Cars {
    val list = emptyList<Car>().toMutableList()

    fun register(numOfCar: Int) {
        for (idx in 1..numOfCar) {
            list.add(Car())
        }
    }
}
