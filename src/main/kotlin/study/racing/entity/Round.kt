package study.racing.entity

class Round(
    private var cars: List<RacingCar>
) {
    var record: List<Int>? = null
        private set
    private val isOver: Boolean get() = record != null

    fun race() {
        if (isOver) throw IllegalStateException("이 라운드는 이미 종료되었습니다.")
        cars
            .onEach(RacingCar::moveForward)
            .also { cars ->
                record = cars.map { it.currentPosition }
            }
    }
}
