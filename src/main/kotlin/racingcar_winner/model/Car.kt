package racingcar_winner.model

public class Car private constructor(
    val name: String
) {
    var progress: Int = 0
        private set

    fun tryToMoveForward(randomNumber: Int) {
        if (checkPossibleToMove(randomNumber)) moveToForward()
    }

    private fun moveToForward() {
        progress += 1
    }

    private fun checkPossibleToMove(randomNumber: Int): Boolean {
        return randomNumber > CRITERIA_NUMBER
    }

    companion object {

        const val CRITERIA_NUMBER = 4

        fun makeCar(name: String): Car {
            checkNameLength(name)
            return Car(name)
        }

        private fun checkNameLength(name: String) {
            if (name.length > 5) throw IllegalArgumentException("# 이름의 길이가 5자보다 길 수 없습니다. 현재이름: $name")
        }
    }
}
