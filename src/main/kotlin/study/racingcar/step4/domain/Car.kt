package study.racingcar.step4.domain

import study.racingcar.step4.Racing

class Car(private val name: String) : Racing {

    private var position: Int = 0
    private val carValidation = CarValidation()

    init {
        carValidation.validationCarNameLength(name)
    }

    override fun run(runnable: Boolean) {
        goAndPause(runnable)
    }

    override fun getPosition(): Int {
        return position
    }

    override fun getName(): String {
        return name
    }

    private fun goAndPause(isGo: Boolean) {
        if (isGo) {
            position++
        }
    }
}
