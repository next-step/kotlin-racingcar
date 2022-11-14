package racingcar

class CarRacing(
    private val count: Int = 1,
    private val carRacers: List<CarRacer>
) {
    private var cache: RaceResult? = null

    init {
        require(count > 0) { "시도할 횟수는 1이상 이어야 합니다." }
        require(carRacers.isNotEmpty()) { "자동차 경주에 참여할 대상이 없습니다." }
    }

    fun race(): RaceResult {
        if (cache != null) {
            return cache as RaceResult
        }

        val records = mutableListOf<Record>()

        repeat(count) { records.addAll(race(it)) }

        cache = RaceResult(records)

        return cache as RaceResult
    }

    private fun race(round: Round): List<Record> {
        val records = mutableListOf<Record>()

        carRacers.forEach {
            it.drive()
            records.add(Record(round, it))
        }

        return records
    }
}
