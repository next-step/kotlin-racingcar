package study.racingcar.step3

class Car(private val ableNumber: Int, private val no: Int) : Racing, Result {

    private var distance: String = ""

    override fun run(runValue: Int) {
        goAndPause(ableNumber <= runValue)
    }

    override fun show(): String {
        return distance
    }

    private fun goAndPause(isGo: Boolean) {
        if (isGo) {
            distance = "$distance-"
        }
    }
}
