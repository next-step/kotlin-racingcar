package study.racinggame.ui

import study.racinggame.domain.CarPosition

object HyphenCarPositionPrinter {
    fun print(carPosition: CarPosition) {
        println("${carPosition.name} : ${"-".repeat(carPosition.position)}")
    }
}
