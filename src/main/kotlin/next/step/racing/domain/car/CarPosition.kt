package next.step.racing.domain.car

@JvmInline
value class CarPosition(val x: Int) : Comparable<CarPosition> {

    fun move(dx: Int): CarPosition = CarPosition(x + dx)

    override fun compareTo(other: CarPosition): Int = x.compareTo(other.x)
}
