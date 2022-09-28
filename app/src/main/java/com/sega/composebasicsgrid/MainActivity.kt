package com.sega.composebasicsgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sega.composebasicsgrid.data.DataSource
import com.sega.composebasicsgrid.model.Topic
import com.sega.composebasicsgrid.ui.theme.ComposeBasicsGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsGridTheme {
                TopicApp()
            }
        }
    }
}

@Composable
fun TopicApp() {
    TopicCardList(topicList = DataSource().loadTopics())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicCardList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
    ) {
        items(topicList) { item: Topic ->
            TopicCard(topic = item)
        }

    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(bottom = 8.dp), elevation = 4.dp) {
        Row() {
            Image(
                painter = painterResource(id = topic.topicImageResourceId),
                contentDescription = stringResource(
                    id = topic.titleResourceId
                ),
                modifier = modifier
                    .size(width = 68.dp, height = 68.dp)
                    .aspectRatio(1f),

                contentScale = ContentScale.Crop

            )

            Column(

            ) {
                Text(
                    text = stringResource(id = topic.titleResourceId),

                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.numberOfAssociatedCourse.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

        }

    }
}

@Preview
@Composable
fun TopicCardPreview() {
    TopicCard(topic = Topic(R.drawable.architecture, R.string.topic_architecture, 58))


}

@Preview
@Composable
fun TopicCardListPreview() {
    TopicCardList(topicList = DataSource().loadTopics())
}


