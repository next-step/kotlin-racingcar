package study.racingcar.step4

class Car(private val ableNumber: Int, val name: String) : Racing {

    private var position: Int = 0

    override fun run(runValue: Int) {
        goAndPause(ableNumber <= runValue)
    }

    override fun position(): Int {
        return position
    }

    override fun name(): String {
        return name
    }

    private fun goAndPause(isGo: Boolean) {
        if (isGo) {
            position++
        }
    }
}
