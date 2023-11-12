package race.view

import race.domain.SimpleCar
import race.domain.SimpleCars

class Output {
    fun printStatus(cars: SimpleCars) {
        cars.forEach { println("${it.carName.name} : ${visualizeLocation(it)}") }
        println("######################")
    }

    fun visualizeLocation(car: SimpleCar): String {
        return "-".repeat(car.location)
    }

    fun printResult(cars: List<SimpleCar>) {
        val winners = cars.joinToString(", ") { it.carName.name }

        println("$winners 가 최종 우승했습니다.")
    }
}
