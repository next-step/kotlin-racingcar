package racingcar.domain

class Round {

    private lateinit var gameResult: Result

    fun recordResult(result: Result) {
        check(!this::gameResult.isInitialized) { "이미 진행된 라운드입니다" }
        gameResult = result
    }

    fun result(): Result {
        check(this::gameResult.isInitialized) { "라운드가 진행되지 않았습니다." }
        return gameResult
    }
}
