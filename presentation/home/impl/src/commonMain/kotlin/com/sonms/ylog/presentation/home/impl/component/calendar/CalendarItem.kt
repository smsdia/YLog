package com.sonms.ylog.presentation.home.impl.component.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sonms.ylog.core.common.extension.squareByLongerSide
import com.sonms.ylog.core.designsystem.component.image.YLogImage
import com.sonms.ylog.core.designsystem.theme.YLog
import com.sonms.ylog.core.designsystem.theme.YLogTheme
import com.sonms.ylog.presentation.home.impl.model.DayType

@Composable
internal fun CalendarItem(
    text: String,
    image: String,
    dayType: DayType,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 7.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = text,
            color = dayType.textColor(),
            style = YLog.typography.bodySmall,
            modifier = Modifier
                .squareByLongerSide(minSize = 24.dp),
            textAlign = TextAlign.Center,
        )

        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = YLog.colors.neutral.n100,
                    shape = RoundedCornerShape(8.dp)
                )
                .border(
                    width = 1.dp,
                    color = YLog.colors.neutral.n100,
                    shape = RoundedCornerShape(8.dp)
                )
                .dropShadow(
                    shape = RoundedCornerShape(8.dp),
                    shadow = Shadow(
                        color = Color(0xff655090).copy(alpha = 0.2f),
                        offset = DpOffset(x = 0.dp, y = 0.dp),
                        spread = 1.dp,
                        radius = 0.dp
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            YLogImage(
                url = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
private fun CalendarItemPreview() {
    YLogTheme {
        CalendarItem(
            text = "4",
            image = "image",
            dayType = DayType.SUN
        )
    }
}
