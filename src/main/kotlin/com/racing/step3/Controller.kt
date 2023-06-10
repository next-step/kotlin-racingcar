package com.racing.step3

import com.racing.step3.service.CarGameService
import com.racing.step3.util.randomMoveCarStrategy
import com.racing.step3.view.InputView
import com.racing.step3.view.OutputView

object Controller {
    fun work() {
        val carNum = InputView.readCarNumber()
        val stageNum = InputView.readStageNumber()

        OutputView.showResultKeyword()

        var createdCarList = CarGameService.createCarList(carNum)
        repeat(stageNum) {
            createdCarList = CarGameService.moveCar(createdCarList, randomMoveCarStrategy())
            OutputView.showRaceStage(createdCarList.map { it.position })
        }
    }
}
