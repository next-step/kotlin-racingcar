package step3

class RacingField(
    private val cars: Cars
) {
    fun startRace(tryCount: Int): RacingResult {
        validateTryCount(tryCount)
        val racingRecords = mutableListOf<RacingRecord>()
        repeat(tryCount) {
            cars.race()
            racingRecords.add(cars.getCurrentRacingRecord())
        }
        return RacingResult(racingRecords, cars.findCurrentWinners())
    }

    private fun validateTryCount(tryCount: Int) {
        if (tryCount <= 0) {
            throw IllegalArgumentException("시도 횟수는 0이상이어야 합니다. 입력 값 : $tryCount")
        }
    }
}
