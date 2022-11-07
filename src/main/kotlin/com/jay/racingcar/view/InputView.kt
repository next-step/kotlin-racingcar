package com.jay.racingcar.view

class InputView {
    companion object {
        fun printCarInputMessage() {
            println("자동차 대수는 몇 대인가요?")
        }

        fun printTryMessage() {
            println("시도할 횟수는 몇 회인가요?")
        }

        fun inputMessage(): String? {
            return readLine()
        }
    }
}
