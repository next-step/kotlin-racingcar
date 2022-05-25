package study.racingCar.domain

class Car(var movedSteps: Int = 0, var tryCounts: Int = 0) {

    fun moveOneStep(trigger: Int = (0..9).random()): Car {
        if (trigger >= MOVE_CONDITION) movedSteps++
        tryCounts++

        return this
    }

    companion object {
        const val MOVE_CONDITION = 4
    }
}