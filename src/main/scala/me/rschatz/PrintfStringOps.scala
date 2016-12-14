package me.rschatz

import java.math.BigInteger

import scala.collection.mutable

object PrintfStringOps {
  private val pattern = "\\%[\\w]+".r
  private val twoComplRef = BigInteger.ONE.shiftLeft(64)

  private val unsignedDecimalInteger = "%u"
  private val string = "%s"

  implicit class AdditionalSpecifiers(val s: String) {
    def formatx(args: Any*): String = {
      if (args != null) {
        val occurences = mutable.Map.empty[String, Int]
        var arguments = args.toList
        pattern.findAllIn(s).zipWithIndex.foreach {
          case (specifier, i) =>
            if (i < arguments.size) {
              specifier match {
                case s: String if s == unsignedDecimalInteger =>
                  val count = occurences.getOrElse(unsignedDecimalInteger, 0)
                  occurences.put(unsignedDecimalInteger, count + 1)

                  val x = new BigInteger(arguments(i).toString)
                  val out = if (x.compareTo(BigInteger.ZERO) < 0) {
                    x.add(twoComplRef)
                  } else {
                    x
                  }
                  arguments = arguments.updated(i, out.toString)
                case _ =>
                // do nothing
              }
            }
        }

        // for each of the supported specifiers replace as many we had arguments for with %s, so we get
        // the correct MissingFormatArgumentException if the user didn't specify enough args
        occurences.keys.foldLeft(s) {
          case (current, key) =>
            Range(0, occurences.getOrElse(key, 0)).foldLeft(current) {
              case (now, _) => now.replaceFirst(key, string)
            }
        }.format(arguments :_ *)
      } else {
        s.format(args)
      }
    }
  }
}
