package step3.domain

/**
 *
 * @author Leo
 */
class RaceManager {

    fun getParticipants(participantCount: Int): List<Car> {
        val forwardStrategy = ForwardImpl()

        return MutableList(participantCount) {
            Car(forwardStrategy)
        }
    }

    fun startRace(totalCount: Int, cars: List<Car>): List<MovingHistory> {
        val movingHistories = mutableListOf<MovingHistory>()
        cars.forEach {
            movingHistories.add(it.finishRace(totalCount))
        }

        return movingHistories
    }
}
