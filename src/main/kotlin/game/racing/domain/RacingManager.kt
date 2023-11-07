package game.racing.domain

class RacingManager(val cars: List<Car>) {

    fun moveCars(moveStrategy: () -> Int) {
        cars.forEach {
            it.moveOrStayBySpeed(moveStrategy())
        }
    }

    fun determineWinner(): List<Car> {
        val biggestPosition = cars.maxOf { it.position }
        return cars.filter { it.position == biggestPosition }
    }
}
