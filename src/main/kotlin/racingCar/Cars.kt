package racingCar

class Cars(numberOfPlayer: Int) {
    var cars = mutableListOf<Car>()

    init {
        for (car in 0 until numberOfPlayer) {
            cars.add(Car())
        }
    }
}
