package com.nextstep.jngcii.racingcar.view

class InputView {
    fun getCarCount(): Int {
        print("자동차 대수는 몇 대인가요? ")

        val input = readLine()

        return kotlin.runCatching {
            input?.toInt()
        }.getOrElse {
            throw IllegalArgumentException("정수만 입력 가능합니다.")
        } ?: throw IllegalArgumentException("숫자를 입력해주세요.")
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
