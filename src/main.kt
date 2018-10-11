import java.util.Date
fun main(args: Array<String>){

    println("Hola mundo")

    // Int edad = 29;

    // Mutable -> Cambiarse / Reasignar

    var edad: Int = 29

    edad = 10

    // Inmutable -> No puede cambiarse / No se puede reasignar

    val edadInmutable:Int = 29


    // Duck Typing

    var curso = 101 // Inferi que es un Int

    curso = 102

    var nombre = "Jose"

    var apellido = "tAYUPANTA"

    var casado = true

    var sueldo = 100

    var fechaNacimiento = Date()

    println(fechaNacimiento.toString())
    //println(Usuario.toString())


    when(casado){
        false -> println("$nombre es Feliz ") // template strings
        true -> println("${nombre} esta triste ") // template strings
        else -> {
            println("No me voy a ejecutar")
            println("Ni yo tampoco")
        }
    }

    var bono = if (casado) 1000.00 else 0.00

    val sueldoTotal = calcularSueldo(bono)
    println(sueldoTotal)

    val adrian = Usuario("Jose", "Tayupanta","Bohorquez")
    println(adrian)

}

fun calcularSueldo(bono: Double): Double{
    var sueldo = 800.00
    return sueldo + bono
}

fun saludar(): Unit{
    println("Hola mundo")
}

class Usuario (public var nombre: String){
    //public var nombre:String

    public var apellido: String = " "

    constructor(vNombre: String, vApellido: String,vApellidoMaterno: String): this (vNombre){
        this.apellido = vApellido
    }
    /*
    constructor(vNombre: String){
        this.nombre = vNombre
        nombre = vNombre
    }*/

    override fun toString(): String{
        val apellidoMayus = if(!apellido.isNullOrBlank()) this.apellido?.toUpperCase() else " "
        return "Hola ${this.nombre} $apellidoMayus"
    }

}
