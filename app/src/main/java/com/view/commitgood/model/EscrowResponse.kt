package com.view.commitgood.model

import com.google.gson.annotations.SerializedName

data class EscrowResponse(

	@field:SerializedName("wallet_balance")
	val walletBalance: WalletBalance? = null
)

data class WalletBalance(

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("tokens")
	val tokens: Int? = null
)
