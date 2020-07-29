package model

interface DiceStatus {
    fun dice(): Int
    fun availableMove(diceValue: Int): Boolean
}
