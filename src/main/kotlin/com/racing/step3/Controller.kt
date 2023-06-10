package com.racing.step3

import com.racing.step3.service.CarGameService
import com.racing.step3.util.randomMoveCarStrategy
import com.racing.step3.view.InputView
import com.racing.step3.view.OutputView

object Controller {
    fun work() {
        var carNum = carNumberSetting()
        var stageNum = stageNumSetting()

        OutputView.showResultKeyword()

        showResult(carNum, stageNum)
    }

    private fun carNumberSetting(): Int {
        var carNum = 0
        InputView.readCarNumber {
            carNum = readln().toInt()
        }
        return carNum
    }

    private fun stageNumSetting(): Int {
        var stageNum = 0
        InputView.readStageNumber {
            stageNum = readln().toInt()
        }
        return stageNum
    }

    private fun showResult(carNum: Int, stageNum: Int) {
        var createdCarList = CarGameService.createCarList(carNum)
        for (i in 1..stageNum) {
            createdCarList = CarGameService.moveCar(createdCarList, randomMoveCarStrategy())
            OutputView.showRaceStage(createdCarList.map { it.position })
        }
    }
}
