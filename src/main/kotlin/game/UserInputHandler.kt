package game

interface UserInputHandler {
    fun askForCarNames(): String
    fun askForRetryCount(): Int
}
