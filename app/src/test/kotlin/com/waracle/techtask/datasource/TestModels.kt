package com.waracle.techtask.datasource

import com.waracle.techtask.models.CakesItem

val firstCake = CakesItem(
    title = "banana cake",
    image = "imageOne",
    desc = "descOne"
)

val secondCake = CakesItem(
    title = "coffee cake",
    image = "imageTwo",
    desc = "descTwo"
)

val thirdCake = CakesItem(
    title = "danish cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fourthCake = CakesItem(
    title = "eclair cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fifthCake = CakesItem(
    title = "french fancy",
    image = "imageTwo",
    desc = "descTwo"
)

val sixthCake = CakesItem(
    title = "gingerbread cake",
    image = "imageTwo",
    desc = "descTwo"
)

val sortedCakeResponse = listOf(
    CakesItem(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    CakesItem(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val filteredCakeResponse = listOf(
    CakesItem(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    CakesItem(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakesItem(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val cakesResponse: List<CakesItem?> = listOf(firstCake, secondCake, null)

