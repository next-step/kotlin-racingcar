package src.racingcar

class Car {

    private var moveCounts: List<Int> = emptyList()

    fun move(tryCount: Int, randomValue: Int): Car {
        var moveCount = 0
        for (i in 0 until tryCount) {
            if (4 <= randomValue) {
                moveCount++
            }
            this.moveCounts += moveCount
        }

        return this
    }

    fun getMoveCountSize(): Int {
        return moveCounts.size
    }

    fun getMoveCountIndex(index: Int): Int {
        return moveCounts[index]
    }
}
