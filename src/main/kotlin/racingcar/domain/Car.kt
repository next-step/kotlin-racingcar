package racingcar.domain

data class Car(val carName: String, val movingDistance: Int) {
    constructor(carName: String, movingCount: Int, movingStrategy: MovingStrategy) : this(
        carName,
        movingDistance = MovingDistance.startRacing(movingCount, movingStrategy),
    ) {
        validateCount(carName, movingCount)
    }

    private fun validateCount(
        carName: String,
        movingCount: Int,
    ) {
        require(carName.length >= 1 && carName.length <= 5) { "자동차 이름은 1~5자리입니다." }
        require(movingCount > 0) { "이동횟수는 0이하가 될 수 없습니다." }
    }
}
