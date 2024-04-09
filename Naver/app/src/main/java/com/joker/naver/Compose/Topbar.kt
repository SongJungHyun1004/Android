package com.joker.naver.Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material.icons.outlined.Sms
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            val iconSize = 40.dp
            Row(
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "menu",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Paid,
                    contentDescription = "pay",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
            }
            Row(
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Sms,
                    contentDescription = "talk",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "notify",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "account",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
            }
        }
    }
}