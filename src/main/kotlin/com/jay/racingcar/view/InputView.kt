package com.jay.racingcar.view

object InputView {
    const val CAR_NAMES_DELIMITER = ","

    fun inputMessage(): String? {
        return readLine()
    }
}
