package com.fajar.foody

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    var nama_makanan: String,
    var deskripsi_makanan: String,
    var photo_makanan: String
) : Parcelable