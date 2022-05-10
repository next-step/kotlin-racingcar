package car.racing

class CarRacing {

    fun newGame(drivers: Int, moves: Int): Game {
        require(drivers > 0)
        require(moves > 0)
        return Game(drivers, moves)
    }
}
