package race

class ResultView {
    fun printResult(cars: List<SimpleCar>) {
        cars.forEach { println(visualizeLocation(it)) }
        println("######################")
    }

    fun visualizeLocation(car: SimpleCar): String {
        return "-".repeat(car.getCurrentlocation())
    }
}
