package racingcar.view

class InputViewImpl : InputView {
    override fun readInput(): String = readLine()!!
}
