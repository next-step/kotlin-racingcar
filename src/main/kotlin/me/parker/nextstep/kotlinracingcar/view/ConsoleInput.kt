package me.parker.nextstep.kotlinracingcar.view

object ConsoleInput {

    const val NAME_DELIMITER = ","

    fun inputNamesOfRacingCar(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        var inputNames: String

        do {
            inputNames = readln()
            if (inputNames.isBlank()) println("자동차 이름은 공백일 수 없습니다. 다시 입력해주세요!")
        } while (inputNames.isBlank())

        return inputNames
    }

    fun inputNumOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")

        var inputNumber: Int

        do {
            inputNumber = readln().toInt()
            if (inputNumber < 1) println("시도 횟수는 1 이상이어야 합니다. 다시 입력해주세요!")
        } while (inputNumber < 1)

        return inputNumber
    }
}