class ResultView {
    fun resultMessage() {
        println("실행 결과")
    }

    fun carDistanceDisplay(cars: List<Car>) {
        val displayString = "-"

        cars.forEach { car ->
            println(displayString.repeat(car.getDistance()))
        }
        println()
    }
}
