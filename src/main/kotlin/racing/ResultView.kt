package racing

class ResultView {
    fun view(list: List<List<Car>>) {

        list.forEach { result ->
            result.forEach { car -> println(car.distance) }
            println()
        }
    }
}
