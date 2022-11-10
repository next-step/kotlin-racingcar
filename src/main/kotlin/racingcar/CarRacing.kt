package racingcar

class CarRacing(
    private val carRacers: List<CarRacer>,
    private var status: Status = Status.READY
) {
    init {
        require(carRacers.isNotEmpty()) { "자동차 경주에 참여할 대상이 없습니다." }
    }
}
