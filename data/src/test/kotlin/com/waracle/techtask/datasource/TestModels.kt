package com.waracle.techtask.datasource

val firstCake = com.waracle.techtask.model.CakeItemDomain(
    title = "banana cake",
    image = "imageOne",
    desc = "descOne"
)

val secondCake = com.waracle.techtask.model.CakeItemDomain(
    title = "coffee cake",
    image = "imageTwo",
    desc = "descTwo"
)

val thirdCake = com.waracle.techtask.model.CakeItemDomain(
    title = "danish cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fourthCake = com.waracle.techtask.model.CakeItemDomain(
    title = "eclair cake",
    image = "imageTwo",
    desc = "descTwo"
)

val fifthCake = com.waracle.techtask.model.CakeItemDomain(
    title = "french fancy",
    image = "imageTwo",
    desc = "descTwo"
)

val sixthCake = com.waracle.techtask.model.CakeItemDomain(
    title = "gingerbread cake",
    image = "imageTwo",
    desc = "descTwo"
)

val sortedCakeResponse = listOf(
    com.waracle.techtask.model.CakeItemDomain(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val filteredCakeResponse = listOf(
    com.waracle.techtask.model.CakeItemDomain(
        title = "banana cake",
        image = "imageOne",
        desc = "descOne"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "coffee cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "danish cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "eclair cake",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "french fancy",
        image = "imageTwo",
        desc = "descTwo"
    ),
    com.waracle.techtask.model.CakeItemDomain(
        title = "gingerbread cake",
        image = "imageTwo",
        desc = "descTwo"
    )
)

val cakesResponse: List<com.waracle.techtask.model.CakeItemDomain?> = listOf(firstCake, secondCake, null)

