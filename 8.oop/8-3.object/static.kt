package main.kotlin.oop.`object`

class Person private constructor(
    var name: String,
    var age: Int
) {

    // static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니고 정적으로 인스턴스끼리 값 공유
    // companion object : 클래스와 동행하는 유일한 오브젝트 (동반 객체)

    // companion object 에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것을 추천

    companion object {
        private const val MIN_AGE = 1   // const 사용 방법은 dart 와 동일 (컴파일 or 런타임 할당 차이)
        fun newBaby(name:String): Person {
            return Person(name, MIN_AGE)
        }
    }

}

class Person2 private constructor(

) {
    // java 와 다른점 -> 동반객체도 하나의 객체로 간주. 때문에 이름을 붙일 수도 있고, interface 구현도 가능
    companion object Factory : Log {
        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory ")
        }
    }
}
interface Log {
    fun log()
}



class Person3 private constructor(
    var name: String,
    var age: Int
) {
    companion object Factory : Log {
        private const val MIN_AGE = 1

        // java 에서 kotlin companion object 를 사용하려면 @JvmStatic 을 붙여주면 된다.
        // java 에서 끌어다 쓸 때 예시로
        // Person3 person = Person3.Factory.newBaby("Tim");     -> @JvmStatic 없을 때
        // Person3 person = Person3.newBaby("Tim");     -> @JvmStatic 있을 떈 바로 접근 가능

        @JvmStatic
        fun newBaby(name:String): Person3 {
            return Person3(name, MIN_AGE)
        }
        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory ")
        }
    }
}



/*
java 의 static 변수와 함수를 만들려면, kotlin 에서는 companion object 를 사용
companion object 도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고, 다른 타입을 상속받을 수도 있음
 */