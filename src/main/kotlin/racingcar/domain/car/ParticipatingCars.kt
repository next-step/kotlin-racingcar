package racingcar.domain.car

class ParticipatingCars(
    private val carList: List<Car>
) {

    fun move() {
        this.carList.forEach {
            it.move()
        }
    }

    fun winners(): List<Pair<String, Int>> {
        val winnerPosition = this.carList.maxOf { it.currentPositionToInt() }
        return this.carList
            .filter { it.currentPositionToInt() == winnerPosition }
            .map { it.name to it.currentPositionToInt() }
    }

    fun currentPosition(): List<Pair<String, Int>> = carList.map { it.name to it.currentPositionToInt() }
}
