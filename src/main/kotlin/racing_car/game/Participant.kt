package racing_car.game

class Participant(numOfCar: Int) {
    val cars = emptyList<Car>().toMutableList()

    init {
        for (idx in 1..numOfCar) {
            cars.add(Car())
        }
    }
}
