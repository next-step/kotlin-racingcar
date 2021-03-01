package racingcar.userinterface

import racingcar.domain.Results

class Console : UserInterface {

    override fun inputCarCount(): String {
        println("자동차 대수는 몇 대인가요?")
        return readLine() ?: ""
    }

    override fun inputRoundCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine() ?: ""
    }

    override fun outputResult(results: Results) {
        println("실행 결과")
        println(results)
    }
}
