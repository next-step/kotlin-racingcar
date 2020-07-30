package racingcar

class ResultView(private val time: Int, private val cars: List<Car>) {
    fun view() {
        println("${time}번째 시도 입니다")
        cars.forEach { println("${it.name} : " + makeResultCarMove(it)) }
        println()
    }

    fun viewWinner() {
        val winner = Winner(cars)
        var strWinner = ""
        winner.winnerList.forEach { strWinner += "${it.name} " }
        println(strWinner.trim() + "가 최종 우승했습니다.")
    }

    private fun makeResultCarMove(car: Car): String = "-".repeat(car.position)
}
