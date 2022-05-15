package racingCar

interface IDrawer {
    fun paintFor(view: String)
}

class Drawer : IDrawer {
    override fun paintFor(view: String) = println(view)
}