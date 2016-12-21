# printf-ext
Adds support for additional printf specifiers in Scala.

## Usage

printf-ext adds a new function `formatx` to  the `String`. Anywhere where you want to call it, you need to
have the implicit conversion `AdditionalSpecifiers` in scope. For instance you could add this line to your
package object: `com.github.reikje.specifiers.PrintfStringOps._`

## Specifiers

The following specifiers are now supported on top of what the regular `format` function can do.

| Abbreviation    | Type                                            | Example                                        |
| --------------- |:-----------------------------------------------:| ----------------------------------------------:|
| `%u`            | `unsigned 32-bit numeric`                       | `"%u".formatx(-1) // "4294967295"`             |
| `%llu`          | `unsigned 64-bit numeric`                       | `"%llu".formatx(-1) // "18446744073709551615"` |
| `%x`            | `unsigned 32-bit numeric in hex format`         | `"%x".format(-1) // "ffffffff"`                |
| `%p`            | `unsigned 64-bit pointer address in hex format` | `"%p".format(16) // "0000000000000010"`        |


## Example
```scala
import com.github.reikje.PrintfStringOps._
val s = "Done reading memory block at 0x%p of size %llu".formatx(16, 1024)
println(s) // Done reading memory block at 0x0000000000000010 of size 1024
```