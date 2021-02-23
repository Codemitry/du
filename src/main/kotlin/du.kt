import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import du.DiskUsageUtility
import du.Measurements
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    mainBody {
        ArgParser(args, helpFormatter = null).parseInto(::Args).run {
            val measures = DiskUsageUtility(h, c, si, *files.toTypedArray()).measurements()

            for (measure in measures) {
                println("${measure.key}: ${measure.value.second} ${Measurements.toString(measure.value.first)}")
            }
        }
    }
    exitProcess(0)
}
