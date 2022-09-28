package com.sega.composebasicsgrid.data

import com.sega.composebasicsgrid.R
import com.sega.composebasicsgrid.model.Topic

class DataSource {

    fun loadTopics(): List<Topic> {
        return listOf(
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.business, R.string.topic_business, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.crafts, R.string.topic_crafts, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58),
            Topic(R.drawable.architecture, R.string.topic_architecture, 58)
        )
    }
}