object RacingGame {
    fun play(cars: List<Car>, movingStrategy: MovingStrategy) {
        cars.forEach { car ->
            if (movingStrategy.isMovable()) {
                car.move()
            } else {
                car.stop()
            }
        }
    }

    fun getWinner(cars: List<Car>): Set<String> {
        var max = 0
        val winnerMap = cars.map {
            if (it.getMoved() > max) {
                max = it.getMoved()
            }
            it.carName to it.getMoved()
        }.toMap()

        return winnerMap.filter { it.value.equals(max) }.keys
    }
}
