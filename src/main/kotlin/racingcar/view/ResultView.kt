package racingcar.view

import java.util.stream.Collectors

class ResultView {
    fun printResult(namesAndPositionsOfCars: List<Pair<String, Int>>) {
        val resultString = makeResultString(namesAndPositionsOfCars)
        println(resultString)
        println()
    }

    fun makeResultString(namesAndPositionsOfCars: List<Pair<String, Int>>): String? {
        return namesAndPositionsOfCars
            .stream()
            .map { (name, position) ->
                "$name : ${"-".repeat(position)}"
            }
            .collect(Collectors.joining("\n"))
    }

    fun printWinners(nameOfWinners: List<String>) {
        println("${nameOfWinners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
