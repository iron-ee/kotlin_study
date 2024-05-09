package main.kotlin.oop.class_etc

/*
상속이 가능하도록 추상클래스를 만들까 하는데
외부에서는 이 클래스를 상속받지 않았으면 좋겠어
-> 하위 클래스를 봉인하자

컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
즉, 런타임때 클래스 타입이 추가될 수 없음.

하위 클래스는 같은 패키지에 있어야 함.

Enum 과 다른 점
- 클래스를 상속받을 수 있다.
- 하위 클래스는 멀티 인스턴스가 가능하다.

추상화가 필요한 Entity or DTO 에서 sealed class 매우 유용하게 활용됨
 */


sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 2_000L)
class Sonata : HyundaiCar("소나타", 3_000L)
class Grandeur : HyundaiCar("그렌져", 4_000L)



private fun selectCar(car: HyundaiCar) {
    when (car) {
        is Avante -> println("${Avante().price}")
        is Sonata -> println("${Sonata().price}")
        is Grandeur -> println("${Grandeur().price}")
    }
}

fun main() {
    selectCar(Sonata())
}


/*
Enum Class 보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시 when 과 함께 주로 사용됨.
 */