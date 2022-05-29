package _3_racing_car.ui

import _3_racing_car.service.dto.RacingOutputDto

data class ResultView(val dto: RacingOutputDto) {

    fun print() {
        println("실행 결과")
        dto.racers.forEach { (name, location) ->
            println("$name : ${MARKED.repeat(location)}")
        }
        println("${dto.winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    companion object {
        const val MARKED = "-"
    }
}
