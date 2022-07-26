package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun OutlinedInput(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    label: String,
    textStyle: TextStyle,
    enabled: Boolean = true,
    maxLines: Int = 10,
    singleLine: Boolean = false,
    readOnly: Boolean = false,
    onValueChange: (String) -> Unit = { valueState.value = it },
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    onAction: KeyboardActions = KeyboardActions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null

) {
    OutlinedTextField(
        modifier = modifier,
        value = valueState.value,
        singleLine = singleLine,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        maxLines = maxLines,
        enabled = enabled,
        textStyle = textStyle,
        readOnly = readOnly,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon


    )
}