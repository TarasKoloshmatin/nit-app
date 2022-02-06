package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.SrcResponse
import com.inquisitor.domain.model.SrcModel

fun SrcResponse.mapToModel() = SrcModel(
    original = this.original,
    large2x = this.large2x,
    medium = this.medium,
    large = this.large,
    small = this.small,
    portrait = this.portrait,
    landscape = this.landscape,
    tiny = this.tiny
)