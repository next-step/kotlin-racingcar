package com.nextstep.racingcar.view

class InputView {

    fun inputNumberOfCars(): Int {
        return readLine()!!.toInt()
    }

    fun inputNumberOfRounds(): Int {
        return readLine()!!.toInt()
    }
}
