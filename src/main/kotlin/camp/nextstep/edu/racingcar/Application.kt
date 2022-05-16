package camp.nextstep.edu.racingcar

import camp.nextstep.edu.racingcar.interfaces.CarTrackView
import camp.nextstep.edu.racingcar.interfaces.cli.InputReader
import camp.nextstep.edu.racingcar.interfaces.cli.ResultWriter
import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Racing

fun main() {
    val (carNames, moveCount) = InputReader.readRacingInputs()

    val participants = carNames.mapIndexed { i, name -> Car(i, name) }
    val racing = Racing.new(participants, moveCount)

    racing.start()
    val carTracks = racing.result()

    for (i in 0 until moveCount) {
        for ((car, track) in carTracks) {
            ResultWriter.writeResult(CarTrackView(car, track), i)
        }
        ResultWriter.writeBlank()
    }

    ResultWriter.writeWinner(racing.winners().toList())
}
