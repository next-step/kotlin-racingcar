package study.racingcar.step3

class Car(private val ableNumber: Int, private val no: Int) : Racing, Result {

    private var position: Int = 0

    override fun run(runValue: Int) {
        goAndPause(ableNumber <= runValue)
    }

    override fun render(): String {
        return (1..position).joinToString(separator = "") { "-" }
    }

    private fun goAndPause(isGo: Boolean) {
        if (isGo) {
            position++
        }
    }
}
