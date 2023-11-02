package game.domain

class GameController {

    fun playGame(
        retryCount: Int,
        carFleet: CarFleet,
    ): History {
        var history = History()
        repeat(retryCount) {
            carFleet.advanceAll()
            history = history.addRound(carFleet.cars.carList)
        }
        return history
    }
}
