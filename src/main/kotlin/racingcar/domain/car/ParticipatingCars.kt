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
        val winnerPosition = this.carList.maxOf { it.currentPosition().toInt() }
        return this.carList
            .filter { it.currentPosition().toInt() == winnerPosition }
            .map { it.name to it.currentPosition().toInt() }
            .toList()
    }

    fun currentPosition(): List<Pair<String, Int>> = carList.map { it.name to it.currentPosition().toInt() }
}
