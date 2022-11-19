package racingcar.domain.car

class ParticipatingCars(
    private val carList: List<Car>
) {
    fun initNameList() = this.carList.map { it.name }.toList()

    fun move(outputFunction: (Int, String) -> Unit) {
        carList.forEach {
            it.move()
            outputFunction(it.currentPosition().toInt(), it.name)
        }
    }

    fun winnersNameList(): List<String> {
        return winners().map { it.name }.toList()
    }

    private fun winners(): List<Car> {
        val winnerPosition = this.carList.sortedWith(
            compareBy { p -> p.currentPosition().toInt() }
        ).last().currentPosition()

        return this.carList.filter { it.currentPosition() == winnerPosition }.toList()
    }
}