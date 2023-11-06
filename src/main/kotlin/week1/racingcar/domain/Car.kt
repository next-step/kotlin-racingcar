package week1.racingcar.domain

class Car(
    val name: String,
    private var mileage: Int = DEFAULT_MILEAGE,
) {

    init {
        validateCarInfo()
    }

    fun currentMileage() = mileage

    private fun validateCarInfo() {
        require(name.isNotBlank()) {
            "자동차 이름은 빈 칸을 허용하지 않습니다."
        }
        require(name.length <= 5) {
            "자동차 이름은 5자를 초과해선 안됩니다."
        }
    }

    fun moveOrNotByNum(randomNum: Int) {
        if (isPossibleToDrive(randomNum)) mileage++
    }

    private fun isPossibleToDrive(randomNum: Int) = randomNum >= MIN_NUM_TO_GO

    fun isSameMileage(mileageToCompare: Int) = mileage == mileageToCompare

    companion object {
        private const val DEFAULT_MILEAGE = 0
        const val MIN_NUM_TO_GO = 5
        const val RANDOM_NUM_RANGE = 10
    }
}
