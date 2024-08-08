package widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
fun CommonTextField(text: String,
                    hintText: String,
                    enabled: Boolean,
                    visualTransformation: VisualTransformation = VisualTransformation.None,
                    trailingIcon: @Composable (() -> Unit) = {  },
                    onValueChanged: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = text,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Theme.colors.secondaryTextColor,
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        trailingIcon = { trailingIcon.invoke() },
        placeholder = { Text(text = hintText, color = Theme.colors.hintTextColor) },
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            onValueChanged(it)
        })
}