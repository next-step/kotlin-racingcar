package car_race.logic.system

object MovingSystem {

    private val DICE_RANGE = (0..9)

    fun rollDice(): Int = DICE_RANGE.random()
}
