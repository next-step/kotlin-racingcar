package game.domain

class Round(val carList: List<Car>) {

    fun findWinners(): List<String> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }
}
