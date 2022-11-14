package racingcar

class CarRacing(
    private val count: Int = 1,
    private val carRacers: List<CarRacer>
) {
    private val records: MutableList<Record> = mutableListOf()
    private var result: RaceResult? = null

    init {
        require(count > 0) { "시도할 횟수는 1이상 이어야 합니다." }
        require(carRacers.isNotEmpty()) { "자동차 경주에 참여할 대상이 없습니다." }
    }

    fun race(): RaceResult {
        if (result != null) {
            return result as RaceResult
        }

        repeat(count) { race(it) }

        result = RaceResult(records)

        return result as RaceResult
    }

    private fun race(round: Round) {
        carRacers.forEach {
            it.drive()
            records.add(Record(round, it))
        }
    }
}
