package camp.nextstep.edu.racingcar

import camp.nextstep.edu.racingcar.interfaces.CommandLineInterface
import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Racing

fun main() {
    val cli = CommandLineInterface()

    val carNumber = cli.readCarNumber()
    val moveCount = cli.readMoveCount()

    val participants = IntRange(1, carNumber).map { Car(it) }
    val racing = Racing.new(participants, moveCount)

    racing.start()
    val carTracks = racing.result()

    for (i in 0 until moveCount) {
        for ((_, track) in carTracks) {
            cli.drawTrackTo(track, i)
        }
        cli.drawBlank()
    }
}
