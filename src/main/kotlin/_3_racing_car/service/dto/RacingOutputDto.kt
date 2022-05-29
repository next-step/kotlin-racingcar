package _3_racing_car.service.dto

import _3_racing_car.domain.Winner

data class RacingOutputDto(val racers: Map<String, Int>) {
    val winners = Winner(racers).find()
}
