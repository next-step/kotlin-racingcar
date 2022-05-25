package com.nextstep.jngcii.racingcar.view

object InputView {
    private const val COMMA = ","

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")

        return input.split(COMMA).map { it.trim() }
    }

    fun getTrialCount(): Int {
        print("시도할 횟수는 몇 회인가요? ")

        val input = readLine()

        return kotlin.runCatching {
            input?.toInt()
        }.getOrElse {
            throw IllegalArgumentException("정수만 입력 가능합니다.")
        } ?: throw IllegalArgumentException("숫자를 입력해주세요.")
    }
}
