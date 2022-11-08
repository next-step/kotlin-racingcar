package racingcar

class Car(val order: Int) {
    private val movements = mutableListOf<Int>()

    fun getCurrentPosition(): Int {
        return movements.sum()
    }

    /**
     * get position at  n th trial
     * trialNumber : n th trial (starting from 1)
     */
    fun getPositionAt(atTrial: Int): Int {
        require(atTrial > 0 && atTrial <= movements.size) { "Invalid trial number $atTrial" }
        return movements.take(atTrial).sum()
    }

    fun move(nextMovement: Int) {
        this.movements.add(nextMovement)
    }
}
