package main.kotlin.oop.class_constructor

abstract class Animal (
    protected val species: String,
    protected open val legCount: Int,
) {
    abstract fun move()
}

class Cat (
    species: String
) : Animal(species, 4) { // extends 키워드를 사용하지 않고 : 을 사용한다 그리고 상위 클래스의 생성자를 바로 호출한다.
    override fun move() {   // override 를 필수적으로 붙여줘야 한다.
        println("고양이가 사뿐 사뿐 걸어간다.")
    }
}

class Penguin (
    species: String
) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다 귄 귄")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount     // Custom getter -> Penguin 에서 getter 를 호출하면 legCount + wingCount
        // 추상 프로퍼티가 아니라면, 상속받을 때 open 을 꼭 붙여야 한다.
        // 상위 클래스에 접근하는 키워드는 super 를 사용
    // java, kotlin 모두 추상 클래스는 인스턴스화 할 수 없다.
}

interface Flyable {
    fun act() {     // default 키워드 없이 메소드 구현이 가능하다.
                    // kotlin 에서도 추상 메소드를 만들 수 있다.
        println("파닥 파닥")
    }
}

interface Swimable {

    val swimAbility: Int
        get() = 3       // 기본값을 넣어줄 수도 있음 (2)
    // backing field 가 없는 프로퍼티를 interface 에 만들 수 있다.
    fun act() {
        print("어푸 어푸")
    }
}

class Duck (
    species: String
) : Animal(species, 2), Swimable, Flyable {     // 인터페이스 구현도 : 을 사용함.

    private val wingCount: Int = 2

    override fun move() {
        println("오리가 움직인다 꽥 꽥")
    }

    override fun act() {
        super<Flyable>.act()    // 중복되는 인터페이스를 특정할 때 super<타입>.함수 를 사용
        super<Swimable>.act()
        // java, kotlin 모두 인터페이스를 인스턴스화 할 수 없다.
    }

//    override val swimAbility: Int     // 여기서 구현해 줄 거라 믿을 때 (1)
//        get() = 3

    override val swimAbility: Int
        get() = super.swimAbility       // 또는 이미 기본값 설정해놔도 추가로 구현해 줄 수도 있음 (2)
}



// 클래스를 상속받을 때 주의할 점
open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived Class")
    }
}
// 해당 Derived(300) 을 호출하게 되면
// Base 의 100 값도 Derived 의 300 값도 아닌 0이 출력됨
// 그 이유인즉슨, Base 에서 init 할 때 println(number) 를 함으로써 아직 Derived 의 값을 초기화해서 가져오지도 못했는데 호출했기 때문에
// 아무 값도 없는 Int 의 초기값인 0이 출력되게 된다.
// 그럼으로 상위 클래스를 설계할 때
// 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open 을 피해야 한다.

/*
상속 관련 키워드 4가지 정리
1. final : override 를 할 수 없게 한다. default 로 보이지 않게 존재함.
2. open : override 를 열어 준다.
3. abstract : 반드시 override 해야 한다.
4. override : 상위 타입을 override 하고 있다.
 */

/*
상속 또는 구현을 할 때에 : 을 사용해야 한다.
상위 클래스 상속을 구현할 때 생성자를 반드시 호출해야 한다.
override 를 필수로 붙여야 한다.
추상 멤버가 아니면 기본적으로 override 가 불가능하다. -> open 을 사용해주어야 한다.
상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 얘기치 못한 버그가 생길 수 있다.
 */