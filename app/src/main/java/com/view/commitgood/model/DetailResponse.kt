package com.view.commitgood.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(

	@field:SerializedName("needs")
	val needs: List<Any?>? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("messages")
	val messages: List<Any?>? = null,

	@field:SerializedName("volunteers")
	val volunteers: List<VolunteersItem?>? = null,

	@field:SerializedName("campaign_coordinator")
	val campaignCoordinator: CampaignCoordinator? = null,

	@field:SerializedName("campaign_donation")
	val campaignDonation: CampaignDonation? = null
)

data class Data(

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
	val totalAmount: String? = null,

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

data class VolunteersItem(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("hours")
	val hours: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("campaign_id")
	val campaignId: Int? = null
)

data class CampaignDonation(

	@field:SerializedName("symbol")
	val symbol: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("last_name")
	val lastName: Any? = null,

	@field:SerializedName("message")
	val message: Any? = null,

	@field:SerializedName("campaign_coordinator_id")
	val campaignCoordinatorId: Any? = null,

	@field:SerializedName("charity_coordinator_amount")
	val charityCoordinatorAmount: Any? = null,

	@field:SerializedName("donation_amount")
	val donationAmount: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("user_id")
	val userId: Any? = null,

	@field:SerializedName("charge_id")
	val chargeId: Any? = null,

	@field:SerializedName("charity_id")
	val charityId: Any? = null,

	@field:SerializedName("card_token")
	val cardToken: Any? = null,

	@field:SerializedName("id")
	val id: Any? = null,

	@field:SerializedName("first_name")
	val firstName: Any? = null,

	@field:SerializedName("email")
	val email: Any? = null,

	@field:SerializedName("campaign_id")
	val campaignId: Int? = null,

	@field:SerializedName("charity_amount")
	val charityAmount: Any? = null,

	@field:SerializedName("status")
	val status: Any? = null
)

data class CampaignCoordinator(

	@field:SerializedName("address_state")
	val addressState: String? = null,

	@field:SerializedName("stripe_user_id")
	val stripeUserId: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("location_id")
	val locationId: Any? = null,

	@field:SerializedName("wallet_password")
	val walletPassword: Any? = null,

	@field:SerializedName("alliance_id")
	val allianceId: Any? = null,

	@field:SerializedName("address_line2")
	val addressLine2: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("address_line1")
	val addressLine1: String? = null,

	@field:SerializedName("identification_photo_content_type")
	val identificationPhotoContentType: Any? = null,

	@field:SerializedName("checked_in")
	val checkedIn: Boolean? = null,

	@field:SerializedName("ethereum_address")
	val ethereumAddress: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shipping_label_printed")
	val shippingLabelPrinted: Boolean? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("lat")
	val lat: Double? = null,

	@field:SerializedName("license_photo_file_size")
	val licensePhotoFileSize: Any? = null,

	@field:SerializedName("profile_content_type")
	val profileContentType: String? = null,

	@field:SerializedName("identification_photo_file_name")
	val identificationPhotoFileName: Any? = null,

	@field:SerializedName("profile_file_name")
	val profileFileName: String? = null,

	@field:SerializedName("license_photo_content_type")
	val licensePhotoContentType: Any? = null,

	@field:SerializedName("license_photo_updated_at")
	val licensePhotoUpdatedAt: Any? = null,

	@field:SerializedName("lng")
	val lng: Double? = null,

	@field:SerializedName("church_id")
	val churchId: Any? = null,

	@field:SerializedName("address_country")
	val addressCountry: String? = null,

	@field:SerializedName("license_photo_file_name")
	val licensePhotoFileName: Any? = null,

	@field:SerializedName("region_id")
	val regionId: Any? = null,

	@field:SerializedName("email_confirmed")
	val emailConfirmed: Boolean? = null,

	@field:SerializedName("address_city")
	val addressCity: String? = null,

	@field:SerializedName("confirm_token")
	val confirmToken: String? = null,

	@field:SerializedName("profile_file_size")
	val profileFileSize: Int? = null,

	@field:SerializedName("identification_photo_file_size")
	val identificationPhotoFileSize: Any? = null,

	@field:SerializedName("bitcoin_address")
	val bitcoinAddress: Any? = null,

	@field:SerializedName("profile_updated_at")
	val profileUpdatedAt: String? = null,

	@field:SerializedName("commit_good_address")
	val commitGoodAddress: Any? = null,

	@field:SerializedName("authorization_token")
	val authorizationToken: Any? = null,

	@field:SerializedName("referral_code")
	val referralCode: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("identification_photo_updated_at")
	val identificationPhotoUpdatedAt: Any? = null,

	@field:SerializedName("stripe_access_token")
	val stripeAccessToken: Any? = null,

	@field:SerializedName("expiration")
	val expiration: Any? = null,

	@field:SerializedName("address_zip")
	val addressZip: String? = null,

	@field:SerializedName("stripe_refresh_token")
	val stripeRefreshToken: Any? = null,

	@field:SerializedName("last_checked_in")
	val lastCheckedIn: Any? = null
)
