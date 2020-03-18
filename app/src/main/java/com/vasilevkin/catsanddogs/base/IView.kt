package com.vasilevkin.catsanddogs.base


interface IView {
    fun showLoading()
    fun hideLoading()
    fun showError(msg: String)
}