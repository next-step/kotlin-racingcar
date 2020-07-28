package step3.racing

import step3.racing.car.Car
import step3.racing.car.CarImpl
import step3.racing.const.CAR_NUMBER_ERROR
import step3.racing.const.TURN_NUMBER_ERROR
import step3.turn.Turn
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl

class GameSetupHelper {
    fun askHowManyCars(input: String?): List<Car> {
        try {
            val totalCar = input?.toInt()
            return (0 until totalCar!!).map { CarImpl() }
        } catch (e: Exception) {
            throw RacingCarGame.SetupFailException(CAR_NUMBER_ERROR)
        }
    }

    fun askHowManyTurns(input: String?, turn: Turn): TurnManager {
        try {
            val totalTurn = input?.toInt()
            return TurnManagerImpl(totalTurn!!, turn)
        } catch (e: Exception) {
            throw RacingCarGame.SetupFailException(TURN_NUMBER_ERROR)
        }
    }
}
