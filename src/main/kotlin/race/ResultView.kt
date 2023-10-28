package race

class ResultView {
    fun printResult(cars: List<SimpleCar>) {
        cars.forEach { println(":" + it.getCurrentlocation().length) }
        println("######################")
    }
}
