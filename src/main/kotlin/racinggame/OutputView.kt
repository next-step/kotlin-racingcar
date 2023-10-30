package racinggame

object OutputView {

    fun printRacingResult(racingResult: RacingGameResult) {
        println("실행 결과")
        racingResult.translate().forEach { result ->
            result.forEach {
                println(it)
            }
            println()
        }
    }
}
