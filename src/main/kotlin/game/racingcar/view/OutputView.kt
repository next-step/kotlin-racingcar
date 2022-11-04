package game.racingcar.view

object OutputView {

    fun printOutputToConsole(snapshots: List<List<Int>>) {
        println("실행 결과")
        snapshots.forEach { snapshotOfCars ->
            snapshotOfCars.forEach { location ->
                repeat(location) { print("-") }
                println()
            }
        }
    }
}
