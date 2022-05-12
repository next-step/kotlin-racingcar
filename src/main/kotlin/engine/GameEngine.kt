package engine

import scene.Scene

object GameEngine {

    fun run(scene: Scene) {
        scene.before()
        do {
            scene.update()
        } while (scene.hasNext())
        scene.after()
    }
}
