package camp.nextstep.edu.racingcar

import camp.nextstep.edu.racingcar.interfaces.RacingSnapshotView
import camp.nextstep.edu.racingcar.interfaces.cli.InputReader
import camp.nextstep.edu.racingcar.interfaces.cli.RacingSnapshotWriter
import camp.nextstep.edu.racingcar.interfaces.cli.ResultWriter
import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Racing

fun main() {
    val (carNames, moveCount) = InputReader.readRacingInputs()

    val participants = carNames.mapIndexed { i, name -> Car(i, name) }
    val racing = Racing.new(participants, moveCount)

    racing.start()

    for (i in 1..moveCount) {
        RacingSnapshotWriter.writeRacingSnapshot(RacingSnapshotView(racing, i))
        ResultWriter.writeBlank()
    }

    ResultWriter.writeWinner(racing.winners().toList())
}
