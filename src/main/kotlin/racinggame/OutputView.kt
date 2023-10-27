package racinggame

object OutputView {

    fun printRacingResult(racingResult: List<List<String>>) {
        println("실행 결과")
        racingResult.forEach { result ->
            result.forEach {
                println(it)
            }
            println()
        }
    }
}
