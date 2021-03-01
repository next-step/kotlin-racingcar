package racing.application

import racing.participant.Racer
import racing.participant.RacingCar
import racing.participant.RacingGroup
import racing.participant.RandomPowEngine
import racing.participant.toCarGroup

object RacingCarFactory {

    fun generate(applicationForm: ApplicationForm): RacingGroup {
        return (1..applicationForm.participantCount)
            .map { sequence ->
                RacingCar(
                    racer = Racer(sequence),
                    engine = RandomPowEngine()
                )
            }
            .toCarGroup()
    }
}

