package carracing.domain

const val INIT_POSITION: Int = 1

class Car(var name: Name, var position: Int = INIT_POSITION, val moveStrategy: MoveStrategy = RandomStrategy()) {

    fun move(): Car {
        if (moveStrategy.isMovable()) position++
        return this
    }

    fun getName(): String {
        return name.name
    }
}
