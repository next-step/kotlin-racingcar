package racing.application

import racing.participant.RacingCar
import racing.participant.RacingGroup
import racing.participant.RandomPowEngine
import racing.participant.toCarGroup

object RacingCarFactory {

    fun generate(applicationForm: ApplicationForm): RacingGroup {
        return applicationForm.participants
            .map { name ->
                RacingCar(
                    name = name,
                    engine = RandomPowEngine()
                )
            }
            .toCarGroup()
    }
}

