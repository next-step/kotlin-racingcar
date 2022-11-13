package racingcar.racingcar

class CarManager(
    private val indicatorGenerator: IndicatorGenerator
) {
    fun ready(totalParticipants: Int, turnCount: Int): List<Car> {
        return List(totalParticipants) { Car(indicatorGenerator.generate(turnCount)) }
    }
}
