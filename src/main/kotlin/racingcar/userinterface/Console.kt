package racingcar.userinterface

import racingcar.domain.CarResult
import racingcar.domain.Result
import racingcar.domain.Results
import racingcar.domain.Winner

private const val CAR_NAME_DELIMITER = ","
private const val DISTANCE_SIGN = "-"

class Console : UserInterface {

    override fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine().orEmpty().split(CAR_NAME_DELIMITER)
    }

    override fun inputRoundCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine().orEmpty()
    }

    override fun outputResult(results: Results) {
        println("실행 결과")
        printRounds(results.results)
        printWinners(results.winners)
    }

    private fun printRounds(results: List<Result>) {
        results.forEach { result ->
            result.carResults.forEach { carResult ->
                val carResultOutput = parseCarResultOutput(carResult)
                println(carResultOutput)
            }
            println()
        }
    }

    private fun parseCarResultOutput(carResult: CarResult): String {
        val name = carResult.name
        val distance = (1..carResult.distance).joinToString("") { DISTANCE_SIGN }
        return "$name : $distance"
    }

    private fun printWinners(winners: List<Winner>) {
        val winnerMessage = winners.joinToString(separator = ", ", postfix = "가 최종 우승했습니다.") { it.name }
        println(winnerMessage)
    }
}
