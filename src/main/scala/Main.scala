import wfapp._
import stopwords._
import datastorage.DataStorage
import wfc.WordFrequencyCounter
import java.nio.file.Paths

object Main {
  def main(args: Array[String]) = {
    val wfapp = new WordFrequencyFramework()
    var stop = new StopWordFilter(wfapp)
    var dataStorage = new DataStorage(wfapp, stop)
    var wordFreqCounter = new WordFrequencyCounter(wfapp, dataStorage)

    val filename = Paths.get("src/main/scala/" + args(0)).toAbsolutePath.toString()

    wfapp.run(filename, stop, dataStorage, wordFreqCounter)
  }
}