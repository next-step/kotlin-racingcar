package src.racingcar

class Winner(
    private val racingCars: List<Car>
) {
    fun findWinners(): List<Car> {
        return racingCars.filter { car ->  car.getMoveCount() >=  racingCars.maxOf { it.getMoveCount() }}
    }
}