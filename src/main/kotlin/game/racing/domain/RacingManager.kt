package game.racing.domain

class RacingManager(val cars: List<Car>) {

    fun moveCars(moveStrategy: () -> Int): List<Car> {
        cars.forEach {
            it.moveOrStayBySpeed(moveStrategy())
        }
        return cars
    }

    fun determineWinner(): List<Car> {
        val maxPositionCar = cars.max()
        return cars.filter { maxPositionCar.isSamePosition(it) }
    }
}
