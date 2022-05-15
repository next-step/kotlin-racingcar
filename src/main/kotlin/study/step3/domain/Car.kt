package study.step3.domain

class Car {
    var movedNum = 0

    fun moveOneStep() {
        val randomNum = (0..9).random()
        if (randomNum >= 4) movedNum += 1
    }
}
