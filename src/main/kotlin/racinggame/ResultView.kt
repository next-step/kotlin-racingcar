package racinggame

class ResultView(private val resultMap: HashMap<String, List<Car>>) {
    fun showResult() {
        println("Game Result is ...")
        resultMap.forEach { (_, car) ->
            car.forEach {
                println(it.forwardValue)
            }
            println()
        }
    }
}