package step3.domain

/**
 *
 * @author Leo
 */
class RaceManager {

    fun getParticipants(participantCount: Int): List<Car> {
        val forwardStrategy = ForwardImpl()
        val cars = mutableListOf<Car>()
        for (num in 1..participantCount) {
            cars.add(Car(forwardStrategy))
        }

        return cars
    }

    fun startRace(totalCount: Int, cars: List<Car>): List<MovingHistory> {
        val movingHistories = mutableListOf<MovingHistory>()
        cars.forEach {
            movingHistories.add(it.finishRace(totalCount))
        }

        return movingHistories
    }

}
