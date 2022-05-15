package racinggame.domain.model

import racinggame.domain.car.Car

data class IndividualRacingStepStatus(
    val name: String,
    val proceedLevel: Int
) {
    companion object {
        fun from(car: Car): IndividualRacingStepStatus {
            return IndividualRacingStepStatus(
                name = car.name,
                proceedLevel = car.proceedLevel
            )
        }
    }
}
