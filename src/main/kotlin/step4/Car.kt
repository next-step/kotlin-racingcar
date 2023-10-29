package step4

class Car(
    val name: String,
    private val decider: ForwardDecider = object : ForwardDecider {
        override fun execute(): Boolean {
            return (0..9).random() >= 4
        }
    }
) {

    private var position = 1

    fun getPosition() = position

    fun getCarStatus() = """%-5s : ${"-".repeat(position)}""".format(name)

    private fun isForward() = decider.execute()

    fun doForwardOrNot(): Int {
        if (isForward()) position++
        return position
    }
}
