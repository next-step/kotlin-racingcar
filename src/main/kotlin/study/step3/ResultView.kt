package study.step3

object ResultView {

    fun showResult(
        tryCount: Int,
        carList: List<Car>
    ) {
        println("실행결과")
        (0 until tryCount).forEach { count ->
            carList.forEach { car ->
                val state = car.stateList[count]
                println("-".repeat(state))
            }
            println()
        }
    }
}
