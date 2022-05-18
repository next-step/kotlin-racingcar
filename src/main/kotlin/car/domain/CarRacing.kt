package car.domain

object CarRacing {

    fun newGame(driverNames: List<String>, moves: Int): Game {
        require(driverNames.isNotEmpty())
        require(moves > 0)
        return Game(driverNames, moves)
    }
}
