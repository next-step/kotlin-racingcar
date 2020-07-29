package racingcar

class RacingGame(carNames: List<String>, private var runCnt: Int) {
    companion object {
        val tracks = mutableListOf<Pair<String, Int>>()
    }

    private val cars = CarFactory.makeCars(carNames)

    fun start() {
        cars.forEach { car ->
            car.run(flag = (0..9).random())
            saveCurrentTrack(car.name, car.distance)
        }
        runCnt--
    }

    private fun saveCurrentTrack(name: String, distance: Int) {
        tracks.add(Pair(name, distance))
    }

    fun isOver() = runCnt == 0

    fun findWinners(): List<String> = cars.filter { it.distance == findMaxDistance() }.map { it.name }

    private fun findMaxDistance() = cars.maxBy { it.distance }?.distance ?: runCnt
}
