package com.view.commitgood.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("logged_in")
	val loggedIn: Boolean? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class User(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
