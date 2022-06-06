package racingcar.view

interface InputView {
    fun askCountOfCars(): Int
    fun askCountOfTrial(): Int

    fun askCarNames(): List<String>
}
