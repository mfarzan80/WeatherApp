package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    items: List<String>,
    text: String,
    selectedItemTextColor: Color = MaterialTheme.colors.onBackground,
    itemsTextColor: Color = MaterialTheme.colors.onBackground,
    dropDownIconColor: Color = MaterialTheme.colors.onBackground,
    menuItem: @Composable (index: Int, item: String) -> Unit = { _, it ->
        Text(
            text = it,
            style = MaterialTheme.typography.body1,
            color = itemsTextColor
        )
    },
    onItemChange: (index: Int, item: String) -> Unit,
) {

    var expanded by remember { mutableStateOf(false) }


    Box(modifier = modifier.clickable(
        onClick = { expanded = !expanded }
    )) {
        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.h6,
                    color = selectedItemTextColor
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.wrapContentSize()
                ) {
                    for (i in items.indices) {
                        val item = items[i]
                        DropdownMenuItem(onClick = {
                            expanded = false
                            onItemChange(i, item)
                        }) {
                            menuItem(i, item)
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.width(15.dp))
            IconFont(
                unicode = "\uF104",
                size = 18.sp,
                color = dropDownIconColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.rotate(270f)
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

