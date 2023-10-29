package step3

class Car(
    private val decider: ForwardDecider = object : ForwardDecider {
        override fun execute(): Boolean {
            return (0..9).random() >= 4
        }
    }
) {

    private var position = 1

    fun getPosition() = position

    private fun isForward() = decider.execute()

    fun doForwardOrNot() {
        if (isForward()) position++
    }
}
