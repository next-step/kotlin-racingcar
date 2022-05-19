package com.nextstep.jngcii.racingcar.view

class InputView {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")

        return input.split(COMMA).map {
            it.trim().validate()
        }
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

    private fun String.validate(): String {
        if (this.isBlank()) {
            throw IllegalArgumentException("자동차이름은 공백일 수 없습니다.")
        }

        if (this.length > 5) {
            throw IllegalArgumentException("자동차이름은 ${MAX_CAR_NAME_LENGTH}자를 초과할 수 없습니다.")
        }

        return this
    }

    companion object {
        private const val COMMA = ","
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
