package racing.application

import racing.participant.Racer
import racing.participant.RacingCar
import racing.participant.RacingGroup
import racing.participant.RandomPowEngine
import racing.participant.toCarGroup

object RacingCarFactory {

    fun generate(applicationForm: ApplicationForm): RacingGroup {
        return applicationForm.participants
            .map { name ->
                RacingCar(
                    racer = Racer(name),
                    engine = RandomPowEngine()
                )
            }
            .toCarGroup()
    }
}

