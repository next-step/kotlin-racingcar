package step3.domain

import step3.model.Car

class CarRacer(private val car: Car = Car()) {
    val proceedLevel: Int
        get() = car.proceedLevel

    fun race() {
        if (isCarMovable()) {
            car.proceed()
        }
    }

    private fun isCarMovable() = getCurrentCondition() >= STANDARD_OF_GOOD_CONDITION

    private fun getCurrentCondition() = (0..9).random()

    companion object {
        private const val STANDARD_OF_GOOD_CONDITION = 4
    }
}
