package step3.domain

/**
 *
 * @author Leo
 */
class Car(private val forwardStrategy: Forward) {

    fun finishRace(totalCount: Int): MovingHistory {
        val movingHistory = MovingHistory()
        for (num in 1..totalCount) {
            movingHistory.log(forwardStrategy.moved())
        }

        return movingHistory
    }

}
