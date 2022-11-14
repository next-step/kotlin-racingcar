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
        cache = if (cache != null) cache else tryRace()

        return cache as RaceResult
    }

    private fun tryRace(): RaceResult {
        val records = mutableListOf<Record>()

        repeat(count) { race(it, records) }

        return RaceResult(records)
    }

    private fun race(round: Round, records: MutableList<Record>) {
        carRacers.forEach {
            it.drive()
            records.add(Record(round, it))
        }
    }
}
