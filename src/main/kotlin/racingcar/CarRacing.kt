package racingcar

class CarRacing(
    private val carRacers: List<CarRacer>,
    private var status: Status = Status.READY
) {
    init {
        require(carRacers.isNotEmpty()) { "자동차 경주에 참여할 대상이 없습니다." }
    }

    fun start(count: Int = 1) {
        require(count > 0) { "시도할 횟수는 1이상 이어야 합니다." }
        check(status.isReady()) { "자동차 경주를 시작할 수 없습니다." }

        repeat(count) { race() }

        status = Status.FINISHED
    }

    private fun race() {
        carRacers.forEach { it.drive() }
    }
}
