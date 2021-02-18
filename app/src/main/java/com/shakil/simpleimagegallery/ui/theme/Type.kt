package com.shakil.simpleimagegallery.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.shakil.simpleimagegallery.R

// Set of Material typography styles to start with
val typography = Typography(
        body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        )
        /* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)


val JOST = FontFamily(
        Font(R.font.jost_bold,FontWeight.W700),
        Font(R.font.jost_semibold,FontWeight.W600),
        Font(R.font.jost_regular,FontWeight.W400),
)

val GT_FLEXA = FontFamily(
        Font(R.font.gt_flexa_bold_trial,FontWeight.W700)
)



@Composable
fun facrHeading() =
        MaterialTheme.typography.h4.merge(
                TextStyle(
                        fontFamily = JOST,
                        fontWeight = FontWeight.W700,
                        fontSize = 28.sp,
                )
        )

@Composable
fun facrTopAppBarHeading() =
        MaterialTheme.typography.h6.merge(
                TextStyle(
                        fontWeight = FontWeight.W700,
                        fontSize = 17.sp,
                        fontFamily = GT_FLEXA
                )
        )


@Composable
fun facrButtonText() =
        MaterialTheme.typography.subtitle2.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNameIntial1Text() =
        MaterialTheme.typography.h4.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNameIntial2Text() =
        MaterialTheme.typography.h4.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNameIntial3Text() =
        MaterialTheme.typography.body1.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        fontFamily = JOST
                )
        )




@Composable
fun facrNormal16BodyText() =
        MaterialTheme.typography.body1.merge(
                TextStyle(
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNormal16BodyTextWhiteColor() =
        MaterialTheme.typography.body1.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = JOST
                )
        )


@Composable
fun facrNormal16SubTitleText() =
        MaterialTheme.typography.subtitle1.merge(
                TextStyle(
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = JOST
                )
        )


@Composable
fun facrNormal20BodyText() =
        MaterialTheme.typography.h6.merge(
                TextStyle(
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNormal14SubTitleText() =
        MaterialTheme.typography.subtitle2.merge(
                TextStyle(
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = JOST
                )
        )

@Composable
fun facrNormal14BodyText() =
        MaterialTheme.typography.body2.merge(
                TextStyle(
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = JOST
                )
        )


@Composable
fun facrBold16BodyText() =
        MaterialTheme.typography.body1.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = JOST
                )
        )

@Composable
fun facrBold14Subtitle2Text() =
        MaterialTheme.typography.subtitle2.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = JOST
                )
        )


@Composable
fun facrBold14body2Text() =
        MaterialTheme.typography.body2.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = JOST
                )
        )


@Composable
fun facrBold20Text() =
        MaterialTheme.typography.h6.merge(
                TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontFamily = JOST,
                        textAlign = TextAlign.Center
                )
        )

@Composable
fun facrSemiBold20Text() =
        MaterialTheme.typography.h6.merge(
                TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        fontFamily = JOST,
                        textAlign = TextAlign.Center
                )
        )

@Composable
fun facrSemiBold18Text() =
        MaterialTheme.typography.h6.merge(
                TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        fontFamily = JOST,
                        textAlign = TextAlign.Center
                )
        )
@Composable
fun facrSemiBold17subtitle1Text() =
        MaterialTheme.typography.subtitle1.merge(
                TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp,
                        fontFamily = JOST,
                        textAlign = TextAlign.Center
                )
        )