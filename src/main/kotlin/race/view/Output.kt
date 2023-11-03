package race.view

import race.domain.SimpleCar

class Output {
    fun printStatus(cars: List<SimpleCar>) {
        cars.forEach { println("${it.name} : ${visualizeLocation(it)}") }
        println("######################")
    }

    fun visualizeLocation(car: SimpleCar): String {
        return "-".repeat(car.getLocation())
    }

    fun printResult(cars: List<SimpleCar>) {
        val winners = cars.joinToString(", ") { it.name }

        println("$winners 가 최종 우승했습니다.")
    }
}
