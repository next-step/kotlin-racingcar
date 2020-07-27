package racingcar

object ResultView {
    fun view(cars: List<Car>) {
        cars.forEach {
            printPosition(it)
        }
        println()
    }

    fun viewWinner(winner: List<Car>) {
        println("${winner.joinToString { it.name }}가 최종 우승했습니다.")
    }

    private fun printPosition(car: Car) {
        var distance = distanceBuilder(car)
        println(distance)
    }

    private fun distanceBuilder(car: Car): StringBuilder {
        var distance = StringBuilder()
        distance.append("${car.name} : ")
        for (i in 1..car.currentPosition) {
            distance.append("-")
        }
        return distance
    }
}
