package com.nextstep.jngcii.racingcar.domain

import com.nextstep.jngcii.racingcar.view.ResultView

class Game(
    private val record: Record,
    private val dice: Dice,
) {
    private var isEnd = false

    fun start(resultView: ResultView) {
        startCheck()

        repeat(record.trialCount) {
            for (carIndex in INITIAL_INDEX until record.carCount) {
                val canGo = dice.run()
                record.write(carIndex, canGo)
            }
            resultView.printResult(record)
        }
    }

    private fun startCheck() {
        if (isEnd) throw IllegalStateException("이미 실행된 game입니다.")
        isEnd = true
    }

    companion object {
        private const val INITIAL_INDEX = 0
    }
}
