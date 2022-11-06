package racing.domain

data class Car(val position: Int = 0, private val moveStrategy: MoveStrategy = RandomStrategy.instance) {

    fun move(): Car = if (moveStrategy.canMove()) Car(position + 1) else this
}
