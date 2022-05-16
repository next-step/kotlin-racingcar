package com.nextstep.jngcii.step3.domain

class Game(
    private val record: Record,
    private val dice: Dice
) {
    companion object {
        private const val INITIAL_INDEX = 0
    }

    private var isEnd = false

    fun start() {
        startCheck()

        repeat(record.trialCount) {
            for (carIndex in INITIAL_INDEX until record.carCount) {
                val canGo = dice.run()
                record.write(carIndex, canGo)
            }
        }
    }

    private fun startCheck() {
        if (isEnd) throw IllegalStateException("이미 실행된 game입니다.")
        isEnd = true
    }
}
