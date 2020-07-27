package step3

class RacingField(
    private val cars: Cars
) {
    fun startRace(tryCount: Int): List<RacingResult> {
        validateTryCount(tryCount)
        val racingResults = mutableListOf<RacingResult>()
        repeat(tryCount) {
            cars.race()
            racingResults.add(getCurrentRacingResult())
        }
        return racingResults
    }

    private fun validateTryCount(tryCount: Int) {
        if (tryCount <= 0) {
            throw IllegalArgumentException("시도 횟수는 0이상이어야 합니다. 입력 값 : $tryCount")
        }
    }

    private fun getCurrentRacingResult(): RacingResult {
        return RacingResult(cars.getCarDistances())
    }
}
