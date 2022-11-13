package racingcar

import java.security.SecureRandom

object RacingCarMove {

    fun move(moveCountList: ArrayList<Int>) {
        moveCountList.forEachIndexed { index, _ ->
            if (checkMoveValue(createRandomInt())) {
                moveCountList[index] ++
            }
        }
    }

    fun createRandomInt(): Int = SecureRandom.getInstanceStrong().nextInt(10)

    fun checkMoveValue(value: Int): Boolean = value >= 4

    fun getMoveString(moveCount: Int): String {
        return StringBuilder().apply {
            for (i in 0 until moveCount) {
                append("-")
            }
        }.toString()
    }
}
