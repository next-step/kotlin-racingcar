package racing

class ResultView {
    fun showReadyMessage() {
        println("실행 결과")
    }

    fun printCurrentRound(carList: List<Car>) {
        carList.forEach {
            val pathString = "-".repeat(it.currentLocation)
            println("${it.number}: $pathString")
        }
        println()
    }
}
