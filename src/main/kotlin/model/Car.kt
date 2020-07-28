package model

class Car(val diceStatus: DiceStatus) {
    private var step: Int = 0
    private var stepList: MutableList<Int> = mutableListOf()

    fun getStep(): Int {
        return step
    }
    fun getStepList(): MutableList<Int> {
        return stepList
    }

    fun diceMove() {
        if (diceStatus.availableMove(diceStatus.dice())) {
            step++
        }
        stepList.add(step)
    }
}
