package racing

class ResultView {
    fun view(carList: List<Car>) {
        carList.forEach {
            repeat(it.position) {
                print("-")
            }
            println()
        }
        println()
    }
}