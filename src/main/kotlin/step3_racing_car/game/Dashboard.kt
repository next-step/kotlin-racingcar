package step3_racing_car.game

object Dashboard {
    var cars = ArrayList<Car>()

    fun register(numOfCar: Int) {
        for (idx in 1..numOfCar) {
            cars.add(Car())
        }
    }
}
