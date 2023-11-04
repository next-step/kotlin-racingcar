package study.racingcar.view

class DefaultInputProvider : InputProvider {
    override fun provideInput(): String = readln()
}
