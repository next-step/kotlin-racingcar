package race.view

object ResultView {

    private const val CAR_POSITION = "-"
    fun showResult() {
        println("실행 결과")
    }

    fun showRacing(cars: List<Int>) {
        cars.forEach {
            println(CAR_POSITION.repeat(it))
        }
        println()
    }
}
