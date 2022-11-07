package racing.model

object ResultView {
    private const val CAR_MILEAGE_INDICATOR = "-"

    fun printRaceResult(results: List<List<Car>>) {
        println("실행 결과")
        results.forEach { cars ->
            cars.forEach {
                println(CAR_MILEAGE_INDICATOR.repeat(it.mileage))
            }
            println()
        }
    }
}
