package game.domain

class GameController {

    fun playGame(
        retryCount: Int,
        carFleet: CarFleet,
    ): History {
        val history = History()
        repeat(retryCount) {
            carFleet.advanceAll()
            history.addRound(Round(carFleet.carList))
        }
        return history
    }
}
