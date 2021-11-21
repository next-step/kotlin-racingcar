package step4.domain

/**
 *
 * @author Leo
 */
class Car(private val carName: CarName, private val forwardStrategy: Forward) {

    fun finishRace(totalCount: Int): MovingHistory {
        val movingHistory = MovingHistory(carName)
        val logMovingHistory: (Int) -> Unit = { movingHistory.log(forwardStrategy.moved()) }
        repeat(totalCount, logMovingHistory)

        return movingHistory
    }
}
