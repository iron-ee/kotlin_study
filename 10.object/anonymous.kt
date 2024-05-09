package main.kotlin.`object`

// 익명 클래스
// 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스

interface Movable {
    fun move()
    fun fly()
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

// java 에서는 new 타입이름()
// kotlin 에서는 object : 타입이름
fun active() {
    moveSomething(object : Movable {
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("플라 플라")
        }
    })
}


/*
kotlin 에서 익명 클래스를 만들 때 object : 타입 사용
 */