package racingcar.domain

class RacingGame(carNames: List<String>, private var runCnt: Int) {

    private val cars = CarFactory.makeCars(carNames)
    private val _carsOnTrack = mutableListOf<Car>()
    val carsOnTrack: List<Car>
        get() = _carsOnTrack

    fun runOnce() {
        cars.forEach { car ->
            car.run(flag = (0..9).random())
        }
        _carsOnTrack.addAll(cars)
        runCnt--
    }

    fun isOver() = runCnt == 0

    fun clearTrack() = _carsOnTrack.clear()

    fun findWinners(): List<String> = cars.filter { it.isWinner(findMaxDistance()) }.map { it.name }

    private fun findMaxDistance() = cars.maxBy { it.distance }?.distance ?: runCnt
}
