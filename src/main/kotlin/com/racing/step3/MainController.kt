package com.racing.step3

import com.racing.step3.view.InputView
import com.racing.step3.view.OutputView
import kotlin.random.Random

object MainController {
    fun work() {
        var carNum = 0
        var stageNum = 0
        InputView.show({
            carNum = readLine()!!.toInt()
        }, {
            stageNum = readLine()!!.toInt()
        })

        OutputView.show {
            // 차 생성
            val carList: MutableList<Car> = mutableListOf()
            for (i in 1..carNum) {
                carList.add(Car())
            }

            for (i in 1..stageNum) {
                // 차 이동
                for (car in carList) {
                    car.move { Random.nextInt(10) }
                    for (j in 1..car.position) {
                        print("-")
                    }
                    println()
                }
                println()
            }
        }
    }
}
