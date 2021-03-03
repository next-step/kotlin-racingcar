package racingcar.userinterface

import racingcar.domain.Results

private const val CAR_NAME_DELIMITER = ","
private const val DISTANCE_SIGN = "-"

class Console : UserInterface {

    override fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return (readLine() ?: "").split(CAR_NAME_DELIMITER)
    }

    override fun inputRoundCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine() ?: ""
    }

    override fun outputResult(results: Results) {
        println("실행 결과")

        results.results.forEach { result ->
            result.distances.forEach { distance ->
                (1..distance).map { DISTANCE_SIGN }.forEach { print(it) }
                println()
            }
            println()
        }
    }
}
