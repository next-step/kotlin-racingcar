package game.racingcar.view

import game.racingcar.dto.LocationSnapshot

object OutputView {

    fun printOutputToConsole(snapshots: List<LocationSnapshot>) {
        println("실행 결과")
        snapshots.forEach { locationOfCars ->
            locationOfCars.locations.forEach { snapshot ->
                val (name, location) = snapshot
                print("$name : ")
                repeat(location) { print("-") }
                println()
            }
        }
    }
}
