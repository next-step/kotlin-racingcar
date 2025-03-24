package carracing.game.domain

class CarRacingModel {
    var carsAmount: Int? = null
        private set
    var roundsAmount: Int? = null
        private set

    fun assignCarsAmount(input: String?): Boolean {
        if (isInputValid(input)) {
            carsAmount = input?.toInt()
            return true
        }
        return false
    }

    fun assignRoundsAmount(input: String?): Boolean {
        if (isInputValid(input)) {
            roundsAmount = input?.toInt()
            return true
        }
        return false
    }

    private fun isInputValid(input: String?): Boolean {
        val inputInt = input?.toIntOrNull()
        return inputInt != null
    }
}
