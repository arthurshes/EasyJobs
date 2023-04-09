package com.example.easyjobs.network.model.admodel

data class AdWorkerModel(
    val age_from: Int?,
    val age_to: Int?,
    val candidat: String?,
    val catalogues: List<Catalogue>?,
    val client_logo: String?,
    val education: Education?,
    val experience: Experience?,
    val firm_activity: String?,
    val firm_name: String?,
    val id: Int?,
    val payment_from: Int?,
    val payment_to: Int?,
    val phone: Any?,
    val place_of_work: PlaceOfWork?,
    val profession: String?,
    val town: Town?,
    val type_of_work: TypeOfWork?,
    val work: Any?
)