package study.racinggame.view

import study.racinggame.domain.CarPosition

object HyphenCarPositionPrinter {
    fun print(carPosition: CarPosition) {
        println("${carPosition.participant.name} : ${"-".repeat(carPosition.position.value)}")
    }
}
