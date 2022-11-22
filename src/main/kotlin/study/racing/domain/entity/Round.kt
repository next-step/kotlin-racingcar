package study.racing.domain.entity

class Round(
    private val cars: List<RacingCar>
) {
    var record: List<Record>? = null
        private set
    private val isOver: Boolean get() = record != null

    fun race() {
        if (isOver) throw IllegalStateException("이 라운드는 이미 종료되었습니다.")
        record = cars
            .onEach(RacingCar::moveForward)
            .map(Record::invoke)
    }
}
