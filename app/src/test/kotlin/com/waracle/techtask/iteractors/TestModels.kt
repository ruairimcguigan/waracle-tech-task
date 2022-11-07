package com.waracle.techtask.iteractors

import com.waracle.techtask.model.CakeItemDomain

val firstCake = CakeItemDomain(
    title = "banana cake",
    image = "imageOne",
    desc = "descOne"
)

val secondCake = CakeItemDomain(
    title = "coffee cake",
    image = "imageTwo",
    desc = "descTwo"
)

val thirdCake = CakeItemDomain(
    title = "danish cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fourthCake = CakeItemDomain(
    title = "eclair cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fifthCake = CakeItemDomain(
    title = "french fancy",
    image = "imageTwo",
    desc = "descTwo"
)

val sixthCake = CakeItemDomain(
    title = "gingerbread cake",
    image = "imageTwo",
    desc = "descTwo"
)

val sortedCakeResponse = listOf(
    CakeItemDomain(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    CakeItemDomain(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val filteredCakeResponse = listOf(
    CakeItemDomain(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    CakeItemDomain(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    CakeItemDomain(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val cakesResponse: List<CakeItemDomain?> = listOf(firstCake, secondCake, null)

