package racingcar

class RacingCarGame(private val trialCount: Int,private val seedMaker: SeedMaker, carCount: List<String>) {
    private val defaultCarGoDecide = {
        val randomValue = seedMaker.nextInt()

        randomValue >= DEFAULT_CAN_GO_THRESHOLD
    }

    private val carList = List(carCount.size) { Car(carCount[it], defaultCarGoDecide) }

    val gameResults = GameResults()

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    fun getWinnerResult() = gameResults.getWinnerResult(carList)

    private fun record() {
        gameResults.record(carList)
    }

    private fun proceed() = carList.forEach { it.proceed() }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4

        const val CAR_NAMES_INPUT_DESC = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TRIAL_NUMBER_INPUT_DESC = "시도할 횟수는 몇 회인가요?"
    }
}
