package camp.nextstep.edu.step3

fun main() {
    val cli = CommandLineInterface()

    val carNumber = cli.readCarNumber()
    val moveCount = cli.readMoveCount()

    val racing = Racing.new(carNumber, moveCount)

    racing.start()
    val carTracks = racing.result()

    for (i in 0 until moveCount) {
        for ((_, track) in carTracks) {
            cli.drawTrackTo(track, i)
        }
        cli.drawBlank()
    }
}
