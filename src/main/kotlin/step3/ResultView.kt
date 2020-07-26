package step3

class ResultView {
    fun view(carList: MutableList<Car>) {
        carList.forEach { car -> println(car.distance) }
        println()
    }
}
