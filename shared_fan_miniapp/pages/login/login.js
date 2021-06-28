const { wxRequest } = require("../../utils/util")

// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  formSubmit: function (e) {
    wxRequest('user/login', {
      username: e.detail.value.username,
      password: e.detail.value.password
    }, (res) => {
      if (res.data.code !== 1000) {
        return wx.showToast({
          title: '登录失败'
        })
      }
      wx.showToast({
        title: '登陆成功',
        success() {
          wx.setStorage({
            key: 'userId',
            data: res.data.data.user.userId
          })
          wx.setStorage({
            key: 'token',
            data: res.data.data.token
          })
          wx.setStorage({
            key: 'sessionId',
            data: res.data.data.sessionId
          })
          wx.reLaunch({
            url: '../info/info'
          })
        }
      })
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})