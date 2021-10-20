package racing

class Pedal(private val movingCondition: Int) {

    fun press(): Boolean = (0..9).random() >= movingCondition
}
