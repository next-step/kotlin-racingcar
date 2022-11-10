package com.nextstep.racingcar

class InputView {

    fun inputNumberOfCars(): Int {
        return readLine()!!.toInt()
    }

    fun inputNumberOfRounds(): Int {
        return readLine()!!.toInt()
    }
}
