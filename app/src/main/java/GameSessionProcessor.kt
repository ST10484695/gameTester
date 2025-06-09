object GameSessionProcessor {
    private val dates = ArrayList<String>()
    private val minutes = ArrayList<Int>()
    private val genres = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val gameNames = ArrayList<String>()

    fun addEntry(gameName: String, date: String, minute: Int, rating: Int, genre: String): Boolean {
        return if (gameNames.size < 7) {
            gameNames.add(gameName)
            dates.add(date)
            minutes.add(minute)
            genres.add(genre)
            ratings.add(rating)
            true
        } else {
            false
        }

    }

    fun clearEntries() {
        gameNames.clear()
        dates.clear()
        minutes.clear()
        genres.clear()
        ratings.clear()

    }

    fun getFormattedEntries(): List<String> {
            val entries = mutableListOf<String>()
            for (i in gameNames.indices) {
                entries.add("${gameNames[i]}| ${dates[i]}|${genres[i]}|${minutes[i]}|${ratings[i]}")
            }
            return entries
        }


    fun getAverageMinutes(): Double {
        return if (minutes.isNotEmpty()) {
            minutes.sum().toDouble() / minutes.size
        } else {
            0.0
        }
    }

    fun highestScore():
            Pair<String, Int>? {
        if (ratings.isEmpty()) return null
        val maxRating = ratings.maxOrNull() ?: return null
        val index = ratings.indexOf(maxRating)
        return Pair(gameNames[index], maxRating)
    }

    fun getTotalEntries(): Int {
        return gameNames.size

    }
}
