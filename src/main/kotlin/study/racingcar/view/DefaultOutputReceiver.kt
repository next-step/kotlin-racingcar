package study.racingcar.view

class DefaultOutputReceiver : OutputReceiver {
    override fun receive(output: String) = println(output)
}
