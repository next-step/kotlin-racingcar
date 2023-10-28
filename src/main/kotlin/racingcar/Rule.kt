package racingcar

import java.security.SecureRandom

object Rule {
    private const val CONDITION = 4
    fun isMoveList(carCnt: Int): List<Boolean> {
        val isMoveList = mutableListOf<Boolean>()
        for (i in 0 until carCnt) {
            isMoveList.add(SecureRandom().nextInt(9) > CONDITION)
        }
        return isMoveList
    }

    fun isMoveListTest(numList: List<Int>): List<Boolean> {
        val isMoveList = mutableListOf<Boolean>()
        for (num in numList) {
            isMoveList.add(num > CONDITION)
        }
        return isMoveList
    }
}
