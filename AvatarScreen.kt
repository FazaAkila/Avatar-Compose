package com.example.papbmasyaallah.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.papbmasyaallah.R

private val BaseFaceSizeDefault: Dp = 500.dp
private val BrowSizeDefault: Dp = 250.dp
private val EyeSizeDefault: Dp = 220.dp
private val NoseSizeDefault: Dp = 60.dp
private val MouthSizeDefault: Dp = 100.dp

private val BrowOffsetY: Dp = (-40).dp
private val EyeOffsetY: Dp = 5.dp
private val NoseOffsetY: Dp = 50.dp
private val MouthOffsetY: Dp = 110.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen(
    baseFaceSize: Dp = BaseFaceSizeDefault,
    browSize: Dp = BrowSizeDefault,
    eyeSize: Dp = EyeSizeDefault,
    noseSize: Dp = NoseSizeDefault,
    mouthSize: Dp = MouthSizeDefault,

    browOffsetY: Dp = BrowOffsetY,
    eyeOffsetY: Dp = EyeOffsetY,
    noseOffsetY: Dp = NoseOffsetY,
    mouthOffsetY: Dp = MouthOffsetY
) {

    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    val pinkDark = Color(0xFFE91E63)
    val pinkLight = Color(0xFFFFEBEE)
    val orangeCheck = Color(0xFFFF9800)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AvatarApp") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pinkDark,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(pinkLight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.face_0004),
                    contentDescription = "Base Face",
                    modifier = Modifier.size(baseFaceSize)
                )

                if (showBrow) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0001),
                        contentDescription = "Brow",
                        modifier = Modifier
                            .size(browSize)
                            .offset(y = browOffsetY)
                    )
                }

                if (showEye) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0003),
                        contentDescription = "Eye",
                        modifier = Modifier
                            .size(eyeSize)
                            .offset(y = eyeOffsetY)
                    )
                }

                if (showNose) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0002),
                        contentDescription = "Nose",
                        modifier = Modifier
                            .size(noseSize)
                            .offset(y = noseOffsetY)
                    )
                }

                if (showMouth) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0000),
                        contentDescription = "Mouth",
                        modifier = Modifier
                            .size(mouthSize)
                            .offset(y = mouthOffsetY)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomCheck(label = "Brow", checked = showBrow, color = orangeCheck) {
                    showBrow = it
                }
                CustomCheck(label = "Eye", checked = showEye, color = orangeCheck) {
                    showEye = it
                }
                CustomCheck(label = "Nose", checked = showNose, color = orangeCheck) {
                    showNose = it
                }
                CustomCheck(label = "Mouth", checked = showMouth, color = orangeCheck) {
                    showMouth = it
                }
            }

            Button(
                onClick = {
                    showBrow = true
                    showEye = true
                    showNose = true
                    showMouth = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = orangeCheck,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(0.6f)
            ) {
                Text("Reset Avatar")
            }
        }
    }
}


@Composable
fun CustomCheck(
    label: String,
    checked: Boolean,
    color: Color,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = color,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(label)
    }
}

@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
    AvatarScreen()
}
