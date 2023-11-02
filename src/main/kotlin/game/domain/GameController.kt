package game.domain

class GameController {

    fun playGame(
        retryCount: Int,
        carFleet: CarFleet,
    ): History {
        var varCarFleet = carFleet
        var history = History()
        repeat(retryCount) {
            varCarFleet = varCarFleet.advanceAll()
            history = history.addRound(varCarFleet.cars.carList)
        }
        return history
    }
}
