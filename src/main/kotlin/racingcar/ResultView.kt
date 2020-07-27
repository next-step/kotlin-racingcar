package racingcar

object ResultView {
    fun view(cars: List<Car>) {
        cars.forEach {
            printPosition(it)
        }
        println()
    }

    private fun printPosition(car: Car) {
        var distance = distanceBuilder(car)
        println(distance)
    }

    fun distanceBuilder(car: Car): StringBuilder {
        var distance = StringBuilder()
        for (i in 1..car.currentPosition) {
            distance.append("-")
        }
        return distance
    }
}
