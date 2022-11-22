package study.racing.domain.entity

import study.racing.domain.repository.RoundRepository

class Round(
    private val roundRepository: RoundRepository,
    private val cars: List<RacingCar>
) {
    var records: List<Record>? = null
        private set
    private val isOver: Boolean get() = records != null

    fun race() {
        if (isOver) throw IllegalStateException("이 라운드는 이미 종료되었습니다.")
        records = cars
            .onEach(RacingCar::moveForward)
            .map(Record::invoke)
    }

    fun getWinner(): List<Record> = roundRepository.getWinner(this)
}
