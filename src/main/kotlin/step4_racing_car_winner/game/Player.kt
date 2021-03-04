package step4_racing_car_winner.game

object Player {
    val cars = ArrayList<Car>()

    fun register(numOfCar: Int) {
        for (idx in 1..numOfCar) {
            cars.add(Car())
        }
    }
}
