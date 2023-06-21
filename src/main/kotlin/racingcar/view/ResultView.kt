package racingcar.view

import racingcar.domain.CarName

class ResultView {
    fun printResult(result: List<String>) {
        result.forEach { println(it) }
        println()
    }

    fun printWinnersName(names: Collection<CarName>) {
        println("${names.joinToString(", ")} 가 최종 우승했습니다." )
    }
}
