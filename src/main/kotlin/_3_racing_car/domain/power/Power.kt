package _3_racing_car.domain.power

fun interface Power {
    fun create(from: Int, until: Int): Int
}
