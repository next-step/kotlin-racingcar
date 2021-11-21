package step4.domain

/**
 *
 * @author Leo
 */
class RaceManager(private val forwardStrategy: Forward) {

    fun getParticipants(carNames: List<CarName>): List<Car> {
        return carNames.map { name ->
            Car(name, forwardStrategy)
        }
    }

    fun startRace(totalCount: Int, cars: List<Car>): List<MovingHistory> {
        val movingHistories = mutableListOf<MovingHistory>()
        cars.forEach { car ->
            movingHistories.add(car.finishRace(totalCount))
        }

        return movingHistories
    }

    fun getWinnerNames(movingHistories: List<MovingHistory>): List<String> {
        val maxForwardCount = movingHistories.maxOf { it.getForwardCount() }
        return movingHistories.filter { it.getForwardCount() == maxForwardCount }.map { it.owner.name }
    }
}
