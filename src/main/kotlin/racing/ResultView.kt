package racing

object ResultView {
    fun printRacingResult(racingResult: List<List<String>>) {
        println("실행 결과")
        racingResult.forEach { cars ->
            cars.forEach {
                println(it)
            }
            println()
        }
    }
}
