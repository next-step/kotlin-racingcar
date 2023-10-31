package first_week_carrace

class Car(
    val name: String,
    private val decider: ForwardDecider = ForwardDecider { (0..9).random() >= 4 }
) {

    var position = 1
        private set

    private fun isForward() = decider.execute()

    fun doForwardOrNot(): Int {
        if (isForward()) position++
        return position
    }
}
