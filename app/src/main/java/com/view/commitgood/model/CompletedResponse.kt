package com.view.commitgood.model

import com.google.gson.annotations.SerializedName

data class CompletedResponse(

	@field:SerializedName("data")
	val data: List<DataItemCom?>? = null
)

data class DataItemCom(

	@field:SerializedName("time_length")
	val timeLength: Int? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("address_country")
	val addressCountry: String? = null,

	@field:SerializedName("check_in")
	val checkIn: Boolean? = null,

	@field:SerializedName("image_alt")
	val imageAlt: String? = null,

	@field:SerializedName("region_id")
	val regionId: Any? = null,

	@field:SerializedName("address_state")
	val addressState: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("good_goal_amount")
	val goodGoalAmount: String? = null,

	@field:SerializedName("expiration_date")
	val expirationDate: String? = null,

	@field:SerializedName("campaign_coordinator_id")
	val campaignCoordinatorId: Int? = null,

	@field:SerializedName("address_city")
	val addressCity: String? = null,

	@field:SerializedName("approved")
	val approved: Any? = null,

	@field:SerializedName("video_link")
	val videoLink: Any? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("total_amount")
	val totalAmount: Any? = null,

	@field:SerializedName("goal_amount")
	val goalAmount: String? = null,

	@field:SerializedName("total_good_amount")
	val totalGoodAmount: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("campaign_category_id")
	val campaignCategoryId: Any? = null,

	@field:SerializedName("workflow_state")
	val workflowState: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("address_zip")
	val addressZip: String? = null,

	@field:SerializedName("category")
	val category: Any? = null
)
