package racingcar.view

import racingcar.model.Cars

interface OutputView {
    fun printHeader()

    fun showProgress(result: Cars)
}
