package racingcar.domain

data class RaceResult(var cars: List<Car>) {

    init {
        val max = cars.maxOf { it.currentPosition }
        cars = cars.filter { it.currentPosition == max }
    }
}
