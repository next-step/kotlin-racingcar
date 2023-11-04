package week1.racingcar.domain

import kotlin.random.Random

class Car(
    val name: String,
) {
    var mileage = DEFAULT_MILEAGE
        private set

    init {
        validateCarInfo()
    }

    private fun validateCarInfo() {
        require(name.isNotBlank()) {
            "자동차 이름은 빈 칸을 허용하지 않습니다."
        }
        require(name.length <= 5) {
            "자동차 이름은 5자를 초과해선 안됩니다."
        }
    }

    fun moveOrNot() {
        if (isPossibleToDrive()) mileage++
    }

    private fun isPossibleToDrive() = Random.nextInt(RANDOM_NUM_RANGE) >= MIN_NUM_TO_GO

    fun isSameMileage(mileageToCompare: Int) = mileage == mileageToCompare

    companion object {
        private const val DEFAULT_MILEAGE = 0
        private const val MIN_NUM_TO_GO = 5
        private const val RANDOM_NUM_RANGE = 10
    }
}
