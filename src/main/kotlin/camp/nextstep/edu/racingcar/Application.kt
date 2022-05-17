package camp.nextstep.edu.racingcar

import camp.nextstep.edu.racingcar.interfaces.RacingSnapshot
import camp.nextstep.edu.racingcar.interfaces.cli.RacingInputReader
import camp.nextstep.edu.racingcar.interfaces.cli.RacingResultWriter
import camp.nextstep.edu.racingcar.interfaces.cli.RacingSnapshotWriter
import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Racing

fun main() {
    val (carNames, moveCount) = RacingInputReader.readRacingInputs()

    val participants = carNames.mapIndexed { i, name -> Car(i, name) }
    val racing = Racing.new(participants, moveCount)

    racing.start()

    for (movements in 1..moveCount) {
        RacingSnapshotWriter.writeRacingSnapshot(
            RacingSnapshot(
                racing.carRacingEvents().mapValues { (_, events) -> events.take(movements) }
            )
        )
        RacingResultWriter.writeBlank()
    }

    RacingResultWriter.writeWinner(racing.winners().toList())
}
