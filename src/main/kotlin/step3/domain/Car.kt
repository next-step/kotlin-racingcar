package step3.domain

/**
 *
 * @author Leo
 */
class Car(private val forwardStrategy: Forward) {

    fun finishRace(totalCount: Int): MovingHistory {
        val movingHistory = MovingHistory()
        val logMovingHistory: (Int) -> Unit = { movingHistory.log(forwardStrategy.moved()) }
        repeat(totalCount, logMovingHistory)

        return movingHistory
    }
}
