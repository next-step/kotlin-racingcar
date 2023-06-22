package racingcar.view

class ResultView {
    fun printResult(namesAndPositionsOfCars: List<Pair<String, Int>>) {
        for ((name, position) in namesAndPositionsOfCars) {
            println("$name : ${"-".repeat(position)}")
        }
        println()
    }

    fun printWinners(nameOfWinners: List<String>) {
        println("${nameOfWinners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
