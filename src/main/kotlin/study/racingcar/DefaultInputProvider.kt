package study.racingcar

class DefaultInputProvider : InputProvider {
    override fun provideInput(): String = readln()
}
