package racingcar.domain

class RaceResult(cars: List<Car>) {
    var winnerCars: List<Car>

    init {
        val max = cars.maxOf { it.currentPosition }
        winnerCars = cars.filter { it.currentPosition == max }
    }
}
