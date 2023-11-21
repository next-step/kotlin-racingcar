package racing.domain

data class RacingGame(private val cars: List<Car>, private val movingRule: RacingMovingRule) {
    fun goRacing(): List<CarHistory> {
        var carDtos: MutableList<CarHistory> = mutableListOf()
        repeat(movingRule.movingCount) {
            for (car in cars) {
                car.forward(movingRule)
                carDtos.add(CarHistory(car.name.name, car.route))
            }
        }
        return carDtos
    }
}
