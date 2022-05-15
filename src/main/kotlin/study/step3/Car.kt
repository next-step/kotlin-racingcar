package study.step3

class Car {

    private val movingList = mutableListOf<String>()

    fun moveOneStep() {
        val randomNum = (0..9).random()
        if (randomNum > 4) movingList.add("-")
    }

    fun printCurrentStep() {
        movingList.forEach { print(it) }
    }
}