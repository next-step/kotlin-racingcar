package com.racing.step3

import com.racing.step3.service.CarGameService
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
            carNum = readLine()!!.toInt()
        }
        return carNum
    }

    private fun stageNumSetting(): Int {
        var stageNum = 0
        InputView.readStageNumber {
            stageNum = readLine()!!.toInt()
        }
        return stageNum
    }

    private fun showResult(carNum: Int, stageNum: Int) {
        var createdCarList = CarGameService.createCarList(carNum)
        for (i in 1..stageNum) {
            createdCarList = CarGameService.moveCar(createdCarList)
            createdCarList.forEach() {
                OutputView.showCarPosition(it.position)
            }
            OutputView.showBlank()
        }
    }
}
