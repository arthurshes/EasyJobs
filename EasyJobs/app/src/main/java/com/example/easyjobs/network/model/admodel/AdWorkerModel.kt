package com.example.easyjobs.network.model.admodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("AdWorkModelCache")
data class AdWorkerModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int?=null,
    val age_from: Int?=null,
    val age_to: Int?=null,
    val candidat: String?=null,
    val catalogues: List<Catalogue>?=null,
    val client_logo: String?=null,
    val education: Education?=null,
    val experience: Experience?=null,
    val firm_activity: String?=null,
    val firm_name: String?=null,
    val payment_from: Int?=null,
    val payment_to: Int?=null,
    val phone: Any?=null,
    val place_of_work: PlaceOfWork?=null,
    val profession: String?=null,
    val town: Town?=null,
    val type_of_work: TypeOfWork?=null,
    val work: Any?=null
)