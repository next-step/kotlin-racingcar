package racingcar.game.domain

class Participant(numOfCar: Int) {
    val cars = arrayListOf<Car>()

    init {
        for (idx in 1..numOfCar) {
            cars.add(Car())
        }
    }
}
