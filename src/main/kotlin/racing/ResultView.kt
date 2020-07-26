package racing

class ResultView {
    fun view(list: MutableList<List<Car>>) {

        list.forEach { result ->
            result.forEach { car -> println(car.distance) }
            println()
        }
    }
}
