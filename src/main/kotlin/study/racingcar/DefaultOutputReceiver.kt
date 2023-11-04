package study.racingcar

class DefaultOutputReceiver : OutputReceiver {
    override fun receive(output: String) = println(output)
}
