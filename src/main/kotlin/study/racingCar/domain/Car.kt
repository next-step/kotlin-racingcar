package study.racingCar.domain

class Car(var movedSteps: Int = 0, var tryCounts: Int = 0) {

    fun tryMoveOneStep() {
        if (RANDOM_NUM >= MOVE_CONDITION) movedSteps += 1
        resetRandomNum()
        tryCounts++
    }

    private fun resetRandomNum() {
        RANDOM_NUM = (0..9).random()
    }

    companion object {
        const val MOVE_CONDITION = 4
        var RANDOM_NUM = (0..9).random()
    }
}
