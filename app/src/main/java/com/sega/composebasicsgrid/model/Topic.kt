package com.sega.composebasicsgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @DrawableRes
    val topicImageResourceId: Int,
    @StringRes
    val titleResourceId: Int,
    val numberOfAssociatedCourse: Int
)

